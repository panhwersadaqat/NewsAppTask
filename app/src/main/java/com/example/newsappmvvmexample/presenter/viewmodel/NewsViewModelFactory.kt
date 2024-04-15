package com.example.newsappmvvmexample.presenter.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappmvvmexample.domain.usecases.DeleteSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetEverythingNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.GetSavedNewsUseCase
import com.example.newsappmvvmexample.domain.usecases.SaveNewsUseCase

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class NewsViewModelFactory (
    private val app:Application,
    private val getEverythingNewsUseCase: GetEverythingNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getEverythingNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        ) as T
    }
}