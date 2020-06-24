package com.olehmesh.instacell.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.olehmesh.instacell.R
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("setLogo")
fun CircleImageView.setLogo(url: String?) {

    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_placeholder)
        .into(this)
}

@BindingAdapter("setPageImage")
fun AppCompatImageView.setPageImage(url: String?) {

    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_placeholder)
        .centerCrop()
        .into(this)

}