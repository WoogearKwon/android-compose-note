package com.woogear.data.source

import com.woogear.data.network.dto.response.NetworkUnsplashPhoto

interface NetworkDataSource {

    suspend fun getPhotos(): List<NetworkUnsplashPhoto>
}