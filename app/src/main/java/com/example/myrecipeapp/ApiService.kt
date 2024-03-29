package com.example.myrecipeapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val recipeService = retrofit.create(ApiService::class.java)

//fun getGson(): Gson {
//    return GsonBuilder()
//        .setLenient()
//        .create()
//}


interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}