package com.woogear.data.network.api

import kotlinx.serialization.json.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface UnsplashApi {

    @GET("photos/random")
    suspend fun getRandomPhotos(): Call<JsonObject>
}