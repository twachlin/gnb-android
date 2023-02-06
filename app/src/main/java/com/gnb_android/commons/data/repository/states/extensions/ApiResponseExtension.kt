package com.gnb_android.commons.data.repository.states.extensions

import com.gnb_android.commons.data.repository.states.BusinessErrorDataState
import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.EmptyDataState
import com.gnb_android.commons.data.repository.states.SuccessDataState
import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.BusinessErrorApiResponse
import com.gnb_android.commons.data.datasource.response.EmptyApiResponse
import com.gnb_android.commons.data.datasource.response.NetworkErrorApiResponse
import com.gnb_android.commons.data.datasource.response.SuccessApiResponse
import com.gnb_android.commons.data.repository.states.ErrorDataState

fun <DataIn, DataOut> ApiResponse<DataIn>.mapToDataState(convertOnSuccess: ((DataIn) -> DataOut)): DataState<DataOut> {
    return when (this) {
        is EmptyApiResponse -> {
            EmptyDataState
        }
        is SuccessApiResponse -> {
            SuccessDataState(convertOnSuccess(this.body))
        }
        is BusinessErrorApiResponse -> {
            BusinessErrorDataState
        }
        is NetworkErrorApiResponse -> {
            ErrorDataState
        }
    }
}