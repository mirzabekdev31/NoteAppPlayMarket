package com.mirzabek.noteappplaymarket.presintation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mirzabek.noteappplaymarket.R
import com.mirzabek.noteappplaymarket.databinding.AboutScreenBinding


class InfoScreen : Fragment(R.layout.about_screen) {

    private val binding by viewBinding(AboutScreenBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}