package com.example.m5_lesson_3_pixabay

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("api/")
    fun getImages(@Query("q") search: String,
                  @Query("page") page: Int,
                  @Query("per_page") perPage: Int = 3,
                  @Query("key") key: String = "36301053-0358e408fca9b403460e662d5"
    ): Call<PixaModel>
}