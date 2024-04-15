package com.example.newsappmvvmexample.presenter.di

import com.example.newsappmvvmexample.domain.repository.NewsRepository
import com.example.newsappmvvmexample.domain.usecases.DeleteSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetEverythingNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.SaveNewsUseCase
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
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsheadLinesUseCase(
        newsRepository: NewsRepository
    ):GetEverythingNewsUseCase{
        return GetEverythingNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
     fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
     ): SaveNewsUseCase {
         return SaveNewsUseCase(newsRepository)
     }

    @Singleton
    @Provides
    fun provideGetSavedNewsUseCase(
        newsRepository: NewsRepository
    ):GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedNewsUseCase(
        newsRepository: NewsRepository
    ):DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)
    }
}