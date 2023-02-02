package com.gnb_android.commons.data.datasource.remote.adapters

import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.math.BigDecimal

class TransactionApiModelListAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): List<TransactionApiModel> {
        val list = mutableListOf<TransactionApiModel>()
        reader.beginArray()
        while (reader.hasNext()) {
            list.add(TransactionApiModelAdapter().fromJson(reader))
        }
        reader.endArray()
        return list
    }
}

class TransactionApiModelAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): TransactionApiModel {
        reader.beginObject()
        var sku: String? = null
        var amount: String? = null
        var currency: String? = null
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "sku" -> sku = reader.nextString()
                "amount" -> amount = reader.nextString()
                "currency" -> currency = reader.nextString()
            }
        }
        val currencyApiModel = when (currency) {
            "EUR" -> CurrencyTypeApiModel.EUR
            "USD" -> CurrencyTypeApiModel.USD
            "CAD" -> CurrencyTypeApiModel.CAD
            "GBP" -> CurrencyTypeApiModel.GBP
            "JPY" -> CurrencyTypeApiModel.JPY
            "AUD" -> CurrencyTypeApiModel.AUD
            "SEK" -> CurrencyTypeApiModel.SEK
            "RUB" -> CurrencyTypeApiModel.RUB
            "INR" -> CurrencyTypeApiModel.INR
            else -> CurrencyTypeApiModel.EUR
        }
        reader.endObject()
        return TransactionApiModel(sku!!, BigDecimal(amount), currencyApiModel)
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: TransactionApiModel) {
        writer.beginObject()
        writer.name("sku").value(value.sku)
        writer.name("amount").value(value.amount)
        writer.name("currency").value(value.currency.name)
        writer.endObject()
    }
}