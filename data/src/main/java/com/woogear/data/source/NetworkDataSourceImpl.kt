package com.woogear.data.source

import com.woogear.data.network.api.UnsplashApi
import kotlinx.serialization.json.JsonObject
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSourceImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
): NetworkDataSource {

    override suspend fun getRandomPhotos(): Call<JsonObject> {
        return unsplashApi.getRandomPhotos()
    }
}