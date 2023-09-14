package com.example.hotelapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapplication.databinding.ItemComfortHotelBinding

class ComfortAdapter :
    RecyclerView.Adapter<ComfortAdapter.ComfortHolder>() {
    private var listComforts = ComfortsImages.listImagesComfort

    inner class ComfortHolder(val binding: ItemComfortHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: ComfortHolder, position: Int) {
        with(holder) {
            binding.apply {
                iconHead.setImageResource(listComforts[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComfortHolder {
        val binding =
            ItemComfortHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComfortHolder(binding)
    }

    override fun getItemCount(): Int {
        return listComforts.size
    }
}