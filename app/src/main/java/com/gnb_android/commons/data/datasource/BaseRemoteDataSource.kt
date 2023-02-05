package com.gnb_android.commons.data.datasource

import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.NetworkErrorApiResponse
import com.gnb_android.commons.data.datasource.response.extensions.mapToApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

open class BaseRemoteDataSource {

    suspend fun <Data> request(getApiService: suspend () -> Response<Data>): ApiResponse<Data> {
        return withContext(Dispatchers.IO) {
            return@withContext try {
                getApiService().mapToApiResponse()
            } catch (e: Exception) {
                NetworkErrorApiResponse
            }
        }
    }
}