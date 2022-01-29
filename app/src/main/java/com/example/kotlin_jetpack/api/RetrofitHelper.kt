package com.example.kotlin_jetpack.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
private const val BASE_URL = "https://quotable.io"
    fun getInstance() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

//In Kotlin, object is a special class that only has one instance. If you create a class with the object
//keyword instead of class, the Kotlin compiler makes the constructor private, creates a static reference
//for the object, and initializes the reference in a static block.