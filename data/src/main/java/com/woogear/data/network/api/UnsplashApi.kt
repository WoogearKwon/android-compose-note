package com.woogear.data.network.api

import com.woogear.data.helper.response.ApiResponse
import com.woogear.data.network.dto.response.NetworkUnsplashPhoto
import retrofit2.http.GET

interface UnsplashApi {

    @GET("photos")
    suspend fun getPhotos(): ApiResponse<List<NetworkUnsplashPhoto>>
}