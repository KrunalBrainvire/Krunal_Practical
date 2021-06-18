package com.krunal.brainvire.bind

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.krunal.brainvire.R

class BindAdapter {
    companion object {

        @BindingAdapter(value = ["app:image"], requireAll = true)
        @JvmStatic
        fun bindUrlImage(imageView: ImageView, url: String?) {
            Glide.with(imageView.context)
                .load(url).timeout(60000)
                .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_people))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView)
        }
    }
}