package com.simba.imgurapp.data.models

import android.graphics.drawable.Drawable

data class ImageItemDetails(
    val image: Int,
    val title: String,
    val postedAt: String,
    val additionalImages: Int? = null
)
