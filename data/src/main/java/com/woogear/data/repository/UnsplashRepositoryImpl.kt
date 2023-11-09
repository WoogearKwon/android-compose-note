package com.woogear.data.repository

import com.woogear.data.source.NetworkDataSource
import com.woogear.domain.repository.UnsplashRepository
import kotlinx.serialization.json.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : UnsplashRepository {

    override suspend fun getRandomPhotos() {
        val networkData = networkDataSource.getRandomPhotos()

        networkData.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                println("woogear...response = ${response.body()}")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("woogear....error = ${t.stackTraceToString()}")
            }
        })
    }
}