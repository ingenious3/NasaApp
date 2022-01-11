package com.android.nasaapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDateString() : String {
    val formatter = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())
    return formatter.format(Date())
}