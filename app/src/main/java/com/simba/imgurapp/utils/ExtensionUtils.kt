package com.simba.imgurapp.utils

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Activity.isNetworkConnected(): Boolean {
    val isConnected = NetworkUtils.isNetworkConnected(applicationContext)
    return if (isConnected) true else {
        Toast.makeText(
            this,
            "No internet connection",
            Toast.LENGTH_SHORT
        ).show()
        false
    }
}

fun ProgressBar.showProgressBar(isToShow: Boolean) {
    visibility = if (isToShow) View.VISIBLE else View.GONE
}
