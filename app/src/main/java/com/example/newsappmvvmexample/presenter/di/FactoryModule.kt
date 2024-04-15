package com.example.newsappmvvmexample.presenter.di

import android.app.Application
import com.example.newsappmvvmexample.domain.usecases.DeleteSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetEverythingNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.SaveNewsUseCase
import com.example.newsappmvvmexample.presenter.viewmodel.NewsViewModelFactory
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
class FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getEverythingNewsUseCase: GetEverythingNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getEverythingNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}