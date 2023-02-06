package com.gnb_android.initialization.data

import com.gnb_android.commons.data.datasource.remote.RetrofitFactoryImpl

class DataModule(baseUrl: String) {

    private val retrofitFactory = RetrofitFactoryImpl(baseUrl = baseUrl)

    init {
        retrofitFactory.init()
    }
}