package com.example.hotelapplication.screens.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.Room
import com.example.hotelapplication.R
import com.example.hotelapplication.actionbar.ActionBarCustom
import com.example.hotelapplication.adapter.RoomAdapter
import com.example.hotelapplication.databinding.FragmentRoomHotelBinding

class RoomHotel : Fragment() {
    private lateinit var binding: FragmentRoomHotelBinding
    private val roomHotelModel: RoomHotelViewModel by activityViewModels()
    private val roomAdapter = RoomAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionBarRoom = ActionBarCustom.newInstance(true, "Madinat Makadi")
        openFragment(actionBarRoom, R.id.actionbar)
        observeState()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            roomHotelModel.getRoomHotel()
            initRecyclerRoom()
        }
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

    private fun initRecyclerRoom() {
        binding.apply {
            val linerManager = LinearLayoutManager(activity)
            recyclerRoom.layoutManager = linerManager
            recyclerRoom.adapter = roomAdapter
            roomAdapter.setRoomList(roomHotelModel.roomHotelList.value as ArrayList<Room>)
        }
    }
}