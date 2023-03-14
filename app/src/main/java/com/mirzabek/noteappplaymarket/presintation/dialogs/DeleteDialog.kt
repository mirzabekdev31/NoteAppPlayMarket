package com.mirzabek.noteappplaymarket.presintation.dialogs
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirzabek.noteappplaymarket.R
import com.mirzabek.noteappplaymarket.databinding.DeleteDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DeleteDialog :BottomSheetDialogFragment(){
    private lateinit var binding: DeleteDialogBinding

    private var clickDeleteBtn:(()->Unit)?=null

    fun setDeleteBtn(block:()->Unit){
        clickDeleteBtn=block
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DeleteDialogBinding.inflate(inflater,container,false)
        binding.btnOk.setOnClickListener {
            clickDeleteBtn?.invoke()
            dismiss()
        }
        binding.btnNo.setOnClickListener {
            dismiss()
        }

        binding.dissmissBtn.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}