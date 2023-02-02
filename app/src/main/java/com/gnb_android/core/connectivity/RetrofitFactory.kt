package com.gnb_android.core.connectivity

import com.gnb_android.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

abstract class RetrofitFactory {

    companion object {
        private lateinit var client: OkHttpClient
        private lateinit var converterFactory: Converter.Factory
        private lateinit var baseUrl: String

        private val instance: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .client(client)
                .build()
        }

        fun initRetrofit(
            baseUrl: String,
            converterFactory: Converter.Factory,
            client: OkHttpClient
        ) {
            Companion.converterFactory = converterFactory
            Companion.client = client
            Companion.baseUrl = baseUrl
        }

        fun <T> getRetrofitService(service: Class<T>): T = instance.create(service)
    }

    abstract fun init()
}