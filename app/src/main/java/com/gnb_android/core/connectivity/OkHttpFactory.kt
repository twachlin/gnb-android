package com.gnb_android.core.connectivity

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient

abstract class OkHttpFactory {

    private val connectTimeout = 20L
    private val readTimeout = 20L
    private val callTimeout = 35L
    private val timeUnit = TimeUnit.SECONDS

    protected fun getOkHttpClientBuilder() : OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .callTimeout(callTimeout, timeUnit)
            .connectTimeout(connectTimeout, timeUnit)
            .readTimeout(readTimeout, timeUnit)
    }

    /**
     * Used to customize an OkHttpClient, for example by adding interceptors by build type
     */
    abstract fun makeOkHttpClient(): OkHttpClient
}
