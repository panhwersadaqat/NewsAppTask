package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
     fun execute(): Flow<List<Article>> {
         return newsRepository.getSavedNews()
     }
}