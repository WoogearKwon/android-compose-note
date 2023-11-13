package com.woogear.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.woogear.data.BuildConfig
import com.woogear.data.helper.EnumConverterFactory
import com.woogear.data.helper.interceptor.RequestHeaderInterceptor
import com.woogear.data.helper.response.NetworkResponseAdapterFactory
import com.woogear.data.network.api.UnsplashApi
import com.woogear.domain.model.AppBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideUnsplashRetrofit(
//        appBuildConfig: AppBuildConfig,
        headerInterceptor: RequestHeaderInterceptor
    ): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        }

        return Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(headerInterceptor)
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            setLevel(
                                if (BuildConfig.DEBUG) {
                                    HttpLoggingInterceptor.Level.BODY
                                } else {
                                    HttpLoggingInterceptor.Level.BASIC
                                }
                            )
                        }
                    )
                    .build()
            )
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .addConverterFactory(EnumConverterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): UnsplashApi {
        return retrofit.create(UnsplashApi::class.java)
    }
}