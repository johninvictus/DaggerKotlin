package com.kotlin.invictus.daggerkotlin.api

import com.kotlin.invictus.daggerkotlin.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.io.IOException


class AuthInterceptor(var sessionManager: SessionManager) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

//        val value = "Bearer: " + sessionManager.getAuthToken()
        val value = "token"

        val request = chain.request()
                .newBuilder()
                .addHeader("Authorization", value)
                .build()
        Timber.e(value)
        return chain.proceed(request)
    }

}