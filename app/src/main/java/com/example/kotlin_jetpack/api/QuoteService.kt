package com.example.kotlin_jetpack.api

import com.example.kotlin_jetpack.models.Quotelist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : Response<Quotelist>
}