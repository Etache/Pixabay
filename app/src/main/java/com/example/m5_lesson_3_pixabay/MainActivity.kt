package com.example.m5_lesson_3_pixabay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.m5_lesson_3_pixabay.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var list = arrayListOf<ImageModel>()
    var adapter = PixaAdapter(arrayListOf())
    var page = 1
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }

    private fun initClickers() {
        binding.btnNextPage.setOnClickListener {
            ++page
            binding.requestImage(page)
        }

        binding.btnSearch.setOnClickListener {
            page = 1
            adapter.list.clear()
            binding.requestImage(page)
        }
    }

    private fun ActivityMainBinding.requestImage(page: Int) {
        RetrofitService().api.getImages(binding.etSearchWord.text.toString(), page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse (call: Call<PixaModel>, response: Response<PixaModel>) {
                    Log.e("ahaha", "onResponse: ${response.body()}")

                    response.body()?.let {
                        list = it.hits
                        binding.rvImage.adapter = PixaAdapter(list)
                        adapter.addImages(list)
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ahaha", "onFailure: ${t.message}")
                }
            })
    }
}