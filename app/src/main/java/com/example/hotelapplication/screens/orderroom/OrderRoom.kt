package com.example.hotelapplication.screens.orderroom

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotelapplication.R
import com.example.hotelapplication.actionbar.ActionBarCustom
import com.example.hotelapplication.adapter.TouristAdapter
import com.example.hotelapplication.databinding.FragmentOrderRoomBinding
import com.google.android.material.textfield.TextInputEditText
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.PhoneNumberUnderscoreSlotsParser
import ru.tinkoff.decoro.watchers.MaskFormatWatcher


class OrderRoom : Fragment() {
    private lateinit var binding: FragmentOrderRoomBinding
    private val touristAdapter = TouristAdapter()
    private val orderRoomView: OrderRoomViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderRoomBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionBarRoom = ActionBarCustom.newInstance(true, "Бронирование")
        openFragment(actionBarRoom, R.id.actionbar)
        observeState()
        binding.also {

            it.buttonPay.setOnClickListener {
                val phoneEdit = binding.editTextPhone
                val emailEdit = binding.editTextTextEmailAddress
                if (phoneEdit.error.isNullOrEmpty() && !phoneEdit.text.isNullOrEmpty()) {
                    if (emailEdit.error.isNullOrEmpty() && !emailEdit.text.isNullOrEmpty()) {
                        NavHostFragment.findNavController(this)
                            .navigate(R.id.action_orderRoom_to_paymentOrder)
                    } else {
                        emailEdit.error = "Почта некорректна"
                    }
                } else {
                    phoneEdit.error = "Телефон некорректен"
                }
            }

            formatPhoneEditfield(it.editTextPhone)
            formatEmailEditfield(it.editTextTextEmailAddress)
        }

        binding.buttonAddTourist.setOnClickListener {
            var newListTourist = orderRoomView.listTourist.value
            var newCountTourist = orderRoomView.orderCountTourist.value
            newCountTourist++
            val newTourist = "Турист $newCountTourist"

            newListTourist.add(newTourist)
            Log.d("listTourist", newListTourist.toString())
            orderRoomView.setTouristList(newListTourist)
            orderRoomView.setTouristCount(newCountTourist)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            orderRoomView.getOrder()
            binding.nameHotelOrder.text = orderRoomView.orderRoom.value[0].hotelName

            initAdapterTourist()
        }
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        parentFragmentManager.beginTransaction().replace(idHolder, f).commit()
    }

    private fun formatPhoneEditfield(editText: TextInputEditText) {
        val slots = PhoneNumberUnderscoreSlotsParser().parseSlots("+7 (9__) ___-__-__")
        val inputMask: MaskImpl = MaskImpl.createTerminated(slots)
        inputMask.isShowingEmptySlots = true
        inputMask.isForbidInputWhenFilled = false
        val formatWatcher = MaskFormatWatcher(inputMask)
        formatWatcher.installOn(editText)

        editText.addTextChangedListener {
            if (editText.length() < 18) {
                editText.error = "Телефон некорректен"
                editText.setBackgroundColor(resources.getColor(R.color.error_color))
            }
        }
    }

    private fun formatEmailEditfield(editText: TextInputEditText) {
        editText.addTextChangedListener {
            if (editText.text?.contains(Regex("[А-Яа-я/&?+]")) == true) {
                editText.error = "Почта некорректна"
                editText.setBackgroundColor(resources.getColor(R.color.error_color))
            }
            if (editText.text?.contains(Regex(".ru")) == false) {
                editText.error = "Почта некорректна"
                editText.setBackgroundColor(resources.getColor(R.color.error_color))
            }
        }
    }

    private fun initAdapterTourist() {
        binding.apply {
            val linerManager = LinearLayoutManager(activity)
            touristRecycler.layoutManager = linerManager
            touristRecycler.adapter = touristAdapter
            touristAdapter.setTouristList(orderRoomView.listTourist.value as ArrayList<String>)
        }
    }
}