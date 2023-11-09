package com.woogear.domain.repository

import com.woogear.domain.model.UnsplashPhoto

interface UnsplashRepository {

    suspend fun getPhotos(): List<UnsplashPhoto>

}