package com.mirzabek.noteappplaymarket.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentManager.inTransaction(fm: Fragment, block : FragmentTransaction.() -> Unit){
    val transaction = this.beginTransaction()
    transaction.block()
    transaction.commit()
}

fun FragmentActivity.addFragment(container:Int,fm:Fragment){
    this.supportFragmentManager.inTransaction(fm){
        this.replace(container,fm)
    }
}

fun FragmentActivity.addFragmentSaveStack(container: Int,fm:Fragment){
    this.supportFragmentManager.inTransaction(fm){
        this.replace(container,fm)
        this.addToBackStack(fm::class.java.name)
    }
}

fun FragmentActivity.popBackStack(){
    this.supportFragmentManager.popBackStack()
}

fun Fragment.addFragmentSaveStack(container : Int, fm : Fragment) {
    requireActivity().addFragmentSaveStack(container, fm)
}

fun Fragment.popBackStack() {
    requireActivity().popBackStack()
}

/*
val english:String,
    val type:String,
    val transcript:String,
    val uzbek:String,
    val countable:String,
    val is_favourite:Int
 */