package com.example.newsappmvvmexample.data.repository.dataSource

import com.example.newsappmvvmexample.data.model.APIResponse
import retrofit2.Response

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

interface NewsRemoteDataSource {
    suspend fun getEverything(search : String):Response<APIResponse>
}