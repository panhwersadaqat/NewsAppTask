package com.example.newsappmvvmexample.domain.usecases

import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.repository.NewsRepository
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

class GetEverythingNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(search : String): Resource<APIResponse>{
        return newsRepository.getEverything(search)
    }
}