package com.woogear.compose_note.di

import com.woogear.compose_note.BuildConfig
import com.woogear.domain.model.AppBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppBuildConfigModule {

    @Provides
    fun provideAppBuildConfigInfo(): AppBuildConfig {
        return AppBuildConfig(
            unsplashApiUrl = "https://api.github.com/",
            unSplashAccessKey = BuildConfig.UNSPLASH_ACCESS_KEY,
            unSplashSecretKey = BuildConfig.UNSPLASH_SECRET_KEY
        )
    }
}