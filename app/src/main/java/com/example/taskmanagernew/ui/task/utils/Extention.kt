package com.example.taskmanagernew.ui.task.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.taskmanagernew.R

fun ImageView.loadImage(url:String){

    Glide.with(this).load(url).placeholder(R.drawable.ic_baseline_edit_24).into(this)



}