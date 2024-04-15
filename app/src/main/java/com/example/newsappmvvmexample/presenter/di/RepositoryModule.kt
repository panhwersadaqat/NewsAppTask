package com.example.newsappmvvmexample.presenter.di

import com.example.newsappmvvmexample.data.repository.NewsRepositoryImpl
import com.example.newsappmvvmexample.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappmvvmexample.domain.repository.NewsRepository
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
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ):NewsRepository{
        return NewsRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource)
    }
}