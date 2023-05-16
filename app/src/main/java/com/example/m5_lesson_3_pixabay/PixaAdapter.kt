package com.example.m5_lesson_3_pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import coil.load
import com.example.m5_lesson_3_pixabay.databinding.ItemImageBinding


class PixaAdapter(var list: ArrayList<ImageModel>): Adapter<PixaAdapter.PixaViewHolder>(){

    class PixaViewHolder(var binding: ItemImageBinding):ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.photoView.load(imageModel.largeImageURL)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        return PixaViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun addImages(listImages:ArrayList<ImageModel>) {
        list.addAll(listImages)
    }
}