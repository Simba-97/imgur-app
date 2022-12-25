package com.simba.imgurapp.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageItemDetails(

    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("link")
    @Expose
    val image: String? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("datetime")
    @Expose
    val postedAt: Int? = null,

    @SerializedName("images")
    @Expose
    val additionalImages: List<ImageItemDetails>? = null
)
