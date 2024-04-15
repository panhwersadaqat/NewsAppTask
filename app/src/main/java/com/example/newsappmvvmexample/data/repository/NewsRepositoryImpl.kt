package com.example.newsappmvvmexample.data.repository

import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.model.Article
import com.example.newsappmvvmexample.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
):NewsRepository {

    override suspend fun getEverything(search: String): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getEverything(search))
    }

    private fun responseToResource(response:Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
       return newsLocalDataSource.getSavedArticles()
    }
}