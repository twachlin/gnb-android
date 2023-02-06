package com.gnb_android.commons.data.datasource.remote

import com.gnb_android.commons.data.datasource.remote.adapters.MoshiAdapters
import com.gnb_android.core.connectivity.OkHttpFactory
import com.gnb_android.core.connectivity.RetrofitFactory
import okhttp3.OkHttpClient

class RetrofitFactoryImpl(private val baseUrl: String) : RetrofitFactory() {

    private val okHttpFactory: OkHttpFactory = OkHttpFactoryImpl()
    private val okHttpClient: OkHttpClient = okHttpFactory.makeOkHttpClient()

    override fun init() { initRetrofit(baseUrl, MoshiAdapters.converterFactory, okHttpClient) }
}