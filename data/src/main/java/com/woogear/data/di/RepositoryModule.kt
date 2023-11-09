package com.woogear.data.di

import com.woogear.data.repository.UnsplashRepositoryImpl
import com.woogear.domain.repository.UnsplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUnsplashRepository(impl: UnsplashRepositoryImpl): UnsplashRepository
}