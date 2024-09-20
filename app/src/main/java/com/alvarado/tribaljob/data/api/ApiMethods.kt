package com.alvarado.tribaljob.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiMethods {
    @GET("jokes/categories")
    suspend fun getCategories() : Response<List<String>>
}