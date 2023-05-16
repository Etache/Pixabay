package com.example.m5_lesson_3_pixabay

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(PixabayApi::class.java)
}