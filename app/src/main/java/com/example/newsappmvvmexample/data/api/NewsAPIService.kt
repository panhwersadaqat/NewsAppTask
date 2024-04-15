package com.example.newsappmvvmexample.data.api

import com.example.newsappmvvmexample.BuildConfig
import com.example.newsappmvvmexample.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

interface NewsAPIService {
    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q")
        search:String,
        @Query("apiKey")
        apiKey:String = BuildConfig.API_KEY
    ): Response<APIResponse>
}