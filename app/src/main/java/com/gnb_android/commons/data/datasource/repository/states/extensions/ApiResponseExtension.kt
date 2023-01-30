package com.gnb_android.commons.data.datasource.repository.states.extensions

import com.gnb_android.commons.data.datasource.repository.states.BusinessErrorDataState
import com.gnb_android.commons.data.datasource.repository.states.DataState
import com.gnb_android.commons.data.datasource.repository.states.EmptyDataState
import com.gnb_android.commons.data.datasource.repository.states.SuccessDataState
import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.BusinessErrorApiResponse
import com.gnb_android.commons.data.datasource.response.EmptyApiResponse
import com.gnb_android.commons.data.datasource.response.SuccessApiResponse

fun <Data> ApiResponse<Data>.mapToDataState(): DataState<Data> {
    return when (this) {
        is EmptyApiResponse -> {
            EmptyDataState
        }
        is SuccessApiResponse -> {
            SuccessDataState(this.body)
        }
        is BusinessErrorApiResponse -> {
            BusinessErrorDataState
        }
    }
}