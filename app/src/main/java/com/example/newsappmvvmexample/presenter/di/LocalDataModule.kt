package com.example.newsappmvvmexample.presenter.di

import com.example.newsappmvvmexample.data.db.ArticleDao
import com.example.newsappmvvmexample.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappmvvmexample.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
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
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}