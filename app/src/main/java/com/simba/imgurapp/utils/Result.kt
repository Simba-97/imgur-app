package com.simba.imgurapp.utils

import java.lang.Exception

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null
