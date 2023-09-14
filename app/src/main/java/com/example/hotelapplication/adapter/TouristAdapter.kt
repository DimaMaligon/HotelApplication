package com.example.hotelapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapplication.databinding.ItemTouristHotelBinding


class TouristAdapter : RecyclerView.Adapter<TouristAdapter.TouristHolder>() {
    private var listTourist = mutableListOf<String>()
    private var expandedPosition = -1

    inner class TouristHolder(val binding: ItemTouristHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: TouristHolder, position: Int) {
        with(holder) {
            binding.apply {
                nameTourist.text = listTourist[position]
                buttonCollapseExpand.setOnClickListener {
                    val visabilityBodyCard = cardTourist.visibility

                    if (visabilityBodyCard == View.VISIBLE) {
                        cardTourist.visibility = View.GONE
                    } else {
                        cardTourist.visibility = View.VISIBLE
                    }

                    expandedPosition = holder.adapterPosition
                    notifyItemChanged(expandedPosition)
                }
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TouristAdapter.TouristHolder {
        val binding =
            ItemTouristHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TouristHolder(binding)
    }

    fun setTouristList(listTourist: ArrayList<String>) {
        this.listTourist = listTourist.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listTourist.size
    }
}