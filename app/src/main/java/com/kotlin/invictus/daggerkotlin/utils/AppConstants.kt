package com.kotlin.invictus.daggerkotlin.utils

class AppConstants {
    companion object {
        var BASE_URL: String = "https://api.github.com/"
        val CONNECT_TIMEOUT: Int = 60 * 1000;
        val READ_TIMEOUT: Long = 60 * 1000;
        val WRITE_TIMEOUT: Long = 60 * 1000;
    }
}