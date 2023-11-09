package com.woogear.data.source

import com.woogear.data.helper.response.ApiResponse
import com.woogear.data.helper.response.NetworkResponse
import com.woogear.data.network.api.UnsplashApi
import com.woogear.data.network.dto.response.NetworkUnsplashPhoto
import com.woogear.domain.error.DomainError
import com.woogear.domain.error.ErrorCode
import javax.inject.Inject
import javax.inject.Singleton

//typealias ErrorCodeHandler = (NetworkResponse.ApiError<ApiErrorBody>) -> ErrorCode

@Singleton
class NetworkDataSourceImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
) : NetworkDataSource {

    override suspend fun getPhotos(): List<NetworkUnsplashPhoto> {
        return unsplashApi.getPhotos().getBodyOrThrowError()
    }

    private fun <T : Any> ApiResponse<T>.getBodyOrThrowError(
//        errorCodeConverter: ErrorCodeHandler,
    ): T {
        return when (this) {
            is NetworkResponse.Success -> {
                body
            }

            is NetworkResponse.ApiError -> {
//                throw DomainError(errorCode = errorCodeConverter(this))
                throw DomainError()
            }

            is NetworkResponse.NetworkError -> {
                throw DomainError(
                    errorCode = ErrorCode.NETWORK_ERROR,
                    cause = error
                )
            }

            is NetworkResponse.UnknownError -> {
                throw DomainError(cause = error)
            }
        }
    }
}