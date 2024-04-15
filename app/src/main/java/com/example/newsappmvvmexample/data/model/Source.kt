package com.example.newsappmvvmexample.data.model


import com.google.gson.annotations.SerializedName

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 14/04/24.
 */

data class Source(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)