package com.woogear.domain.repository

interface UnsplashRepository {

    suspend fun getRandomPhotos()

}