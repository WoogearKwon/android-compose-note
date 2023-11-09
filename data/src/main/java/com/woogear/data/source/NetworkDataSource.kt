package com.woogear.data.source

import kotlinx.serialization.json.JsonObject
import retrofit2.Call

interface NetworkDataSource {

    suspend fun getRandomPhotos(): Call<JsonObject>
}