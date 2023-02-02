package com.gnb_android.commons.data.datasource.remote

import com.gnb_android.core.connectivity.OkHttpFactory
import okhttp3.OkHttpClient

class OkHttpFactoryImpl(): OkHttpFactory() {

    override fun makeOkHttpClient(): OkHttpClient {
        return getOkHttpClientBuilder().build()
    }
}