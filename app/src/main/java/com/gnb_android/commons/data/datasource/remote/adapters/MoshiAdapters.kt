package com.gnb_android.commons.data.datasource.remote.adapters

import com.squareup.moshi.Moshi
import retrofit2.converter.moshi.MoshiConverterFactory

class MoshiAdapters {
    companion object {
        val converterFactory: MoshiConverterFactory by lazy {
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(BigDecimalAdapter())
                    .add(TransactionApiModelListAdapter())
                    .add(TransactionApiModelAdapter())
                    .build()
            )
        }
    }
}