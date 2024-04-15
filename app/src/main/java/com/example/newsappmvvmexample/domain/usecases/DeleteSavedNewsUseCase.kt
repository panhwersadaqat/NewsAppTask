package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.domain.repository.NewsRepository

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}