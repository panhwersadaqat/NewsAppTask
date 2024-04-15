package com.example.newsappmvvmexample.presenter.di

import com.example.newsappmvvmexample.data.api.NewsAPIService
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappmvvmexample.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}