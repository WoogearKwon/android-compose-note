package com.woogear.data.helper.interceptor

import com.woogear.domain.model.AppBuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestHeaderInterceptor @Inject constructor(
    private val appBuildConfig: AppBuildConfig,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader(ACCEPT_VERSION_NAME, "v1")
            .addHeader(AUTHORIZATION_HEADER_NAME, appBuildConfig.unSplashAccessKey)
            .build()

        return chain.proceed(newRequest)
    }
}

private const val ACCEPT_VERSION_NAME = "Accept-Version"
private const val AUTHORIZATION_HEADER_NAME = "Authorization"