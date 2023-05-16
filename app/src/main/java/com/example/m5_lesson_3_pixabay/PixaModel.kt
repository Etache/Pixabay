package com.example.m5_lesson_3_pixabay

data class PixaModel(
    var hits: ArrayList<ImageModel>
)

data class ImageModel(
    var largeImageURL:String
)