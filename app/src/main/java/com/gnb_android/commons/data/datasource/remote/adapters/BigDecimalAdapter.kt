package com.gnb_android.commons.data.datasource.remote.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.math.BigDecimal
import java.math.RoundingMode.HALF_UP

class BigDecimalAdapter {
    @FromJson
    fun fromJson(string: String) = BigDecimal(string).setScale(2, HALF_UP)

    @ToJson
    fun toJson(value: BigDecimal) = value.toDouble()
}