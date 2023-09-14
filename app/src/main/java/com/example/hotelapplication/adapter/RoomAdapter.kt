package com.example.hotelapplication.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Room
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.ItemComfortHotelBinding
import com.example.hotelapplication.databinding.ItemRoomHotelBinding
import com.google.android.material.chip.Chip

class RoomAdapter constructor(private val fragment: Fragment):
    RecyclerView.Adapter<RoomAdapter.RoomHolder>() {
    private var listRooms = mutableListOf<Room>()

    inner class RoomHolder(val binding: ItemRoomHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: RoomHolder, position: Int) {
        with(holder) {
            binding.apply {
                val item = listRooms[position]
                nameRoom.text = item.name
                priceRoom.text = "${item.price} ₽"
                priceRoomDesc.text = item.pricePer
                buttonChooseRoom.setOnClickListener {
                    NavHostFragment.findNavController(fragment)
                        .navigate(R.id.action_roomHotel_to_orderRoom)
                }
                addChips(this, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomHolder {
        val binding =
            ItemRoomHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRooms.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setRoomList(listRoom: ArrayList<Room>) {
        this.listRooms = listRoom.toMutableList()
        notifyDataSetChanged()
    }

    private fun addChips(binding: ItemRoomHotelBinding, position: Int){
        val listChips = listRooms[position].peculiarities
        for (item in listChips){
            val newChip = Chip(fragment.activity)
            newChip.text = item
            binding.peculiaritiesList.addView(newChip)
        }
    }
}