package com.woogear.data.repository

import com.woogear.data.network.dto.response.asDomainModel
import com.woogear.data.source.NetworkDataSource
import com.woogear.domain.model.UnsplashPhoto
import com.woogear.domain.repository.UnsplashRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : UnsplashRepository {

    override suspend fun getPhotos(): List<UnsplashPhoto> {
        val networkData = networkDataSource.getPhotos()

        return networkData.map {
            it.asDomainModel()
        }
    }
}