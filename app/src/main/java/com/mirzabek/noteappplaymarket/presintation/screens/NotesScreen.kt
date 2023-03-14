package com.mirzabek.noteappplaymarket.presintation.screens
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirzabek.noteappplaymarket.R
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.databinding.MyDrowerLayoutBinding
import com.mirzabek.noteappplaymarket.presintation.adapters.NotesAdapter
import com.mirzabek.noteappplaymarket.presintation.dialogs.DeleteDialog
import com.mirzabek.noteappplaymarket.presintation.viewmodels.impl.NoteScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NotesScreen :Fragment(R.layout.my_drower_layout){

    private val binding by viewBinding(MyDrowerLayoutBinding::bind)
    private val viewModel by viewModels<NoteScreenViewModelImpl>()

    private val adapter: NotesAdapter by lazy { NotesAdapter(context = requireContext()) }
    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private var _query = ""



    @SuppressLint("NotifyDataSetChanged", "ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }

        binding.inner.NoteList.adapter=adapter
        binding.inner.NoteList.layoutManager=GridLayoutManager(requireContext(),2)
        allNotes()

        binding.inner.SearchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" + getResources().getString(R.string.kkk) + "</font>"))

        binding.inner.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let {
                        scope.launch {
                            if (it != null) {
                                viewModel.getQueryNotes(it.trim()).collectLatest {list->
                                    if (list.isEmpty()){
                                        binding.inner.noteEmpty.visibility=View.VISIBLE
                                    }else{
                                        binding.inner.noteEmpty.visibility=View.INVISIBLE
                                    }
                                    Log.d("TTT","list-> ${list.size}")
                                    adapter.submitList(list as ArrayList<NotesEntity>)
                                }
                            }
                        }
                    adapter.query=it!!.trim()
                    _query=it.trim()
                    adapter.notifyDataSetChanged()
                }
                return true
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextChange(newText: String?): Boolean {
                newText.let {
                        scope.launch {
                            if (it != null) {
                                viewModel.getQueryNotes(it.trim()).collectLatest {list->
                                    if (list.isEmpty()){
                                        binding.inner.noteEmpty.visibility=View.VISIBLE
                                    }else{
                                        binding.inner.noteEmpty.visibility=View.INVISIBLE
                                    }
                                    Log.d("TTT","list-> ${list.size}")
                                    adapter.submitList(list)
                                }
                            }
                        }
                    adapter.query=it!!.trim()
                    _query=it.trim()
                    adapter.notifyDataSetChanged()
                }
                return true
            }

        })

        binding.inner.AboutScreen.setOnClickListener {
            binding.myDrawerLayout.openDrawer(GravityCompat.END)
        }

        binding.nav.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_share->{
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, "Text")
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                    startActivity(Intent.createChooser(sharingIntent, "Share using"))
                }
                R.id.nav_about->{
                    findNavController().navigate(NotesScreenDirections.actionNotesScreenToInfoScreen())
                }
            }
            return@setNavigationItemSelectedListener true
        }

        scope.launch {
            viewModel.getAllNotes().collectLatest {
                if (it.isEmpty()){
                    binding.inner.noteEmpty.visibility=View.VISIBLE
                }else{
                    binding.inner.noteEmpty.visibility=View.INVISIBLE
                }
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        }

        binding.inner.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_notesScreen_to_notesAddScreen)
            viewModel.clickAddButton()
            adapter.notifyDataSetChanged()
        }

//        binding.inner.AboutScreen.setOnClickListener {
//            findNavController().navigate(R.id.action_notesScreen_to_infoScreen)
//        }


//        val id: Int = binding.inner.SearchView.getContext().getResources()
//            .getIdentifier("android:id/edit_query", null, null)
//        binding.inner.editQuery.setTextColor(Color.WHITE)

        adapter.setDeleteBtn {deleteItem->
            scope.launch {
                val deleteDialog=DeleteDialog()
                deleteDialog.show(childFragmentManager,null)
                deleteDialog.setDeleteBtn {
                    viewModel.deleteNotes(deleteItem)
                    adapter.notifyDataSetChanged()
                }
              //  viewModel.deleteNotes(deleteItem)
            }
        }

        adapter.setItemClickListener {updateNotes->
            scope.launch {
                arguments?.putInt("ID",updateNotes.id)
                findNavController().navigate(NotesScreenDirections.actionNotesScreenToEditNoteScreen(updateNotes))
                viewModel.updateNotes(updateNotes)
            }
        }


    }

    fun allNotes(){
        viewModel.getAllNotes()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        adapter.notifyDataSetChanged()
        super.onResume()
    }
}

