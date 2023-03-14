package com.mirzabek.noteappplaymarket.presintation.screens
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirzabek.noteappplaymarket.R
import com.mirzabek.noteappplaymarket.data.sourse.apref.AppPref
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.databinding.NoteAddScreenBinding
import com.mirzabek.noteappplaymarket.extensions.getCurrentData
import com.mirzabek.noteappplaymarket.presintation.viewmodels.impl.NoteAddScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import org.wordpress.aztec.Aztec
import org.wordpress.aztec.ITextFormat
import org.wordpress.aztec.toolbar.IAztecToolbarClickListener


@AndroidEntryPoint
class NotesAddScreen : Fragment(R.layout.note_add_screen) {

    private val binding by viewBinding(NoteAddScreenBinding::bind)
    private val viewModel by viewModels<NoteAddScreenViewModelImpl>()
    private var background: Int = R.drawable.back_def
    private lateinit var appPref: AppPref

    @SuppressLint("ResourceAsColor", "SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editor = binding.Description
        val editorTitle = binding.editTitle
        Aztec.with(editor, binding.toolBar, object : IAztecToolbarClickListener {
            override fun onToolbarCollapseButtonClicked() {}

            override fun onToolbarExpandButtonClicked() {}

            override fun onToolbarFormatButtonClicked(
                format: ITextFormat,
                isKeyboardShortcut: Boolean
            ) {
            }

            override fun onToolbarHeadingButtonClicked() {}

            override fun onToolbarHtmlButtonClicked() {}

            override fun onToolbarListButtonClicked() {}

            override fun onToolbarMediaButtonClicked() = false

        })
        editorTitle.setTextColor(R.color.black)
        editorTitle.setTextColor(requireActivity().getColor(R.color.black))
        editorTitle.highlightColor = R.color.black
        editorTitle.setBackgroundResource(R.drawable.background_searchview)
        Aztec.with(editor, binding.toolBar, object : IAztecToolbarClickListener {
            override fun onToolbarCollapseButtonClicked() {}

            override fun onToolbarExpandButtonClicked() {}

            override fun onToolbarFormatButtonClicked(
                format: ITextFormat,
                isKeyboardShortcut: Boolean
            ) {
            }

            override fun onToolbarHeadingButtonClicked() {}

            override fun onToolbarHtmlButtonClicked() {}

            override fun onToolbarListButtonClicked() {}

            override fun onToolbarMediaButtonClicked() = false

        })
        editor.setTextColor(R.color.black)
        editor.setTextColor(requireActivity().getColor(R.color.black))
        editor.highlightColor = R.color.black
        editor.setBackgroundResource(R.drawable.background_searchview)
        binding.data.text = getCurrentData()
        appPref=AppPref.getInstance()

        binding.checkGreen.visibility=View.VISIBLE

        binding.reed.setOnClickListener {
            background = R.drawable.back_reed
            editorTitle.setBackgroundResource(R.drawable.back_reed)
            editor.setBackgroundResource(R.drawable.back_reed)
            binding.checkReed.visibility=View.VISIBLE
            binding.checkYellow.visibility=View.INVISIBLE
            binding.checkBlue.visibility=View.INVISIBLE
            binding.checkGreen.visibility=View.INVISIBLE
            Log.d("TTT", "red")
            appPref.saveColor="reed"
        }

        binding.yellow.setOnClickListener {
            Log.d("TTT", "yellow")
            background = R.drawable.back_yellow
            editorTitle.setBackgroundResource(R.drawable.back_yellow)
            editor.setBackgroundResource(R.drawable.back_yellow)
            binding.checkReed.visibility=View.INVISIBLE
            binding.checkYellow.visibility=View.VISIBLE
            binding.checkBlue.visibility=View.INVISIBLE
            binding.checkGreen.visibility=View.INVISIBLE
            appPref.saveColor="yellow"
        }

        binding.blue.setOnClickListener {
            Log.d("TTT", "green")
            background = R.drawable.back_green
            editorTitle.setBackgroundResource(R.drawable.back_green)
            editor.setBackgroundResource(R.drawable.back_green)
            binding.checkReed.visibility=View.INVISIBLE
            binding.checkYellow.visibility=View.INVISIBLE
            binding.checkBlue.visibility=View.VISIBLE
            binding.checkGreen.visibility=View.INVISIBLE
            appPref.saveColor="green"
        }

        binding.green.setOnClickListener {
            background=R.drawable.back_def
            editorTitle.setBackgroundResource(R.drawable.back_def)
            editor.setBackgroundResource(R.drawable.back_def)
            binding.checkReed.visibility=View.INVISIBLE
            binding.checkYellow.visibility=View.INVISIBLE
            binding.checkBlue.visibility=View.INVISIBLE
            binding.checkGreen.visibility=View.VISIBLE
            appPref.saveColor="defoult"
        }


        binding.BackBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.AddNotess.setOnClickListener {
            Log.d("TTT", "back${background}")
            if (binding.editTitle.text.toString().isEmpty() || binding.Description.text.toString().isEmpty()){
                Toast.makeText(requireContext(),"Title and Description empty",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.insertNote(
                    NotesEntity(
                        title = binding.editTitle.text.toString(),
                        description = binding.Description.text.toString(),
                        data = binding.data.text.toString(),
                        backColor = background
                    )
                )
                findNavController().popBackStack()
            }
        }
    }
}