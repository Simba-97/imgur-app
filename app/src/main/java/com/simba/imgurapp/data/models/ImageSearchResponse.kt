package com.simba.imgurapp.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageSearchResponse(

    @SerializedName("data")
    @Expose
    val data: List<ImageItemDetails>? = null,

    @SerializedName("success")
    @Expose
    val success: Boolean? = null,

    @SerializedName("status")
    @Expose
    val status: Int? = null

) : Serializable
