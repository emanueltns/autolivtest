package com.example.autolivtest.util

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.example.autolivtest.R

/** Extension  for inflating the layout resource. Can be used in Adapters*/
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ImageView.load(imageUrl : String) : Drawable {
    this.load(imageUrl) {
        crossfade(true)
        placeholder(R.drawable.ic_launcher_background)
        transformations(CircleCropTransformation())
    }
    return this.drawable
}


