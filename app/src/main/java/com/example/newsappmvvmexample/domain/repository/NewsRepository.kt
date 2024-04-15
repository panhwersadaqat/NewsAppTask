package com.example.newsappmvvmexample.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.data.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

interface NewsRepository {
    suspend fun getEverything(search : String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}