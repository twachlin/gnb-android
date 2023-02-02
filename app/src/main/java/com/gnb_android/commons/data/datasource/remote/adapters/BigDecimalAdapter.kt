package com.gnb_android.commons.data.datasource.remote.adapters

import com.squareup.moshi.FromJson
import java.math.BigDecimal

class BigDecimalAdapter {
    @FromJson
    fun fromJson(string: String) = BigDecimal(string)
}