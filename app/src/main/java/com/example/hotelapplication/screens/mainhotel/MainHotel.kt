package com.example.hotelapplication.screens.mainhotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelapplication.R
import com.example.hotelapplication.actionbar.ActionBarCustom
import com.example.hotelapplication.adapter.ComfortAdapter
import com.example.hotelapplication.databinding.FragmentMainHotelBinding
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainHotel : Fragment() {
    private lateinit var binding: FragmentMainHotelBinding
    private val mainModel: MainHotelViewModel by activityViewModels()
    private val adapterComfort = ComfortAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionBarMain = ActionBarCustom.newInstance(false, "Отель")
        openFragment(actionBarMain, R.id.actionbar)

        binding.buttonChooseRoom.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_mainHotel_to_roomHotel)
        }
        observeState()
        initRecyclerComfort()
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainModel.getHotel()
            binding.apply {
                val hotel = mainModel.hotelList.value[0]
                nameHotel.text = hotel.name
                ratingHotel.text = "${hotel.rating} ${hotel.ratingName}"
                adressHotel.text = hotel.adress
                priceHotel.text = "${hotel.minimalPrice} ₽"
                priceDescription.text =hotel.priceForIt
            }
            addChips()
        }
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

    private fun addChips() {
        val listChips = mainModel.hotelList.value[0].aboutTheHotel.peculiarities
        for (item in listChips) {
            val newChip = Chip(activity)
            newChip.text = item
            binding.peculiaritiesList.addView(newChip)
        }
    }

    private fun initRecyclerComfort() {
        binding.apply {
            val linerManager = LinearLayoutManager(activity)
            comfortRecycler.layoutManager = linerManager
            comfortRecycler.adapter = adapterComfort
        }
    }
}