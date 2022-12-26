package com.simba.imgurapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun epochToIso8601(time: Long): String? {
        val format = "dd/MM/yy h:mm a"
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(Date(time * 1000))
    }
}