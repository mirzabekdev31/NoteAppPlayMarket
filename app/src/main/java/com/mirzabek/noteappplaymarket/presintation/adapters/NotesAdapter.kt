package com.mirzabek.noteappplaymarket.presintation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mirzabek.noteappplaymarket.R
import com.mirzabek.noteappplaymarket.databinding.NoteItemsBinding
import com.mirzabek.noteappplaymarket.data.sourse.room.entity.NotesEntity
import com.mirzabek.noteappplaymarket.utils.spannable

class NotesAdapter(var query: String = "", val context: Context) :ListAdapter<NotesEntity,NotesAdapter.ItemViewHolder>(ItemDiffUtil){

    private var clickDeleteBtn:((NotesEntity)->Unit)?=null

    fun setDeleteBtn(block:(NotesEntity)->Unit){
        clickDeleteBtn=block
    }

    private var itemClickListener:((NotesEntity)->Unit)?=null
    fun setItemClickListener(block:(NotesEntity)->Unit){
        itemClickListener=block
    }


    @SuppressLint("SuspiciousIndentation")
    inner class ItemViewHolder(private val binding: NoteItemsBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.Delete.setOnClickListener {
            val data=getItem(absoluteAdapterPosition)
                clickDeleteBtn?.invoke(data)

            }

            binding.root.setOnClickListener {
                val data=getItem(absoluteAdapterPosition)
                itemClickListener?.invoke(data)
            }
        }

        @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
        fun bind(){
            getItem(absoluteAdapterPosition).apply {
                if (query=="") {
                    binding.titleNote.text=title
                }else{
                    binding.titleNote.text=title.spannable(query,context)
                }
                binding.descriptions.text=description
                binding.data.text=data
                Log.d("TTT","##### $backColor")
                binding.container.background = binding.root.context.getDrawable(backColor)
            }
        }
    }

    object ItemDiffUtil:DiffUtil.ItemCallback<NotesEntity>(){
        override fun areItemsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
            return oldItem.id==newItem.id
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: NotesEntity, newItem: NotesEntity): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(NoteItemsBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.note_items,parent,false)))
    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }
}