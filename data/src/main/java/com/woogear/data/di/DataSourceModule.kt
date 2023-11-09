package com.woogear.data.di

import com.woogear.data.source.NetworkDataSource
import com.woogear.data.source.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindNetworkDataSource(impl: NetworkDataSourceImpl): NetworkDataSource
}