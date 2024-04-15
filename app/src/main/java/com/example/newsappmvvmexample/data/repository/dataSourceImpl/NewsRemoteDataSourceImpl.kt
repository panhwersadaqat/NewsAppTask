package com.example.newsappmvvmexample.data.repository.dataSourceImpl

import com.example.newsappmvvmexample.data.api.NewsAPIService
import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
):NewsRemoteDataSource {

    override suspend fun getEverything(search: String): Response<APIResponse> {
        return newsAPIService.getEverything(search)
    }
}