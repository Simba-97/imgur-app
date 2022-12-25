package com.simba.imgurapp.utils

import android.text.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.simba.imgurapp.R
import java.util.*

object BindingUtils {

    @BindingAdapter("profileIcon")
    fun loadAndBindImage(imageView: ImageView, url: String?) {
        val context = imageView.context
        if (!TextUtils.isEmpty(url)) {
            Glide.with(context).load(url).apply(
                RequestOptions.centerCropTransform()
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.placeholder_image)
            ).into(imageView)
        } else {
            Glide.with(context).load(R.drawable.placeholder_image)
                .apply(RequestOptions.fitCenterTransform()).into(imageView)
        }
    }
}