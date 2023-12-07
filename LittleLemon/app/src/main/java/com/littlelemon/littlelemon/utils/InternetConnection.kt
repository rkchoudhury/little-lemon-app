package com.littlelemon.littlelemon.utils

import android.content.Context
import android.net.ConnectivityManager

fun isDeviceConnectedToInternet(context: Context): Boolean {
    val connectivityManager = context
        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.getActiveNetworkInfo()
    return activeNetworkInfo != null && activeNetworkInfo.isConnected()
}