package com.example.hotelapplication.screens.paymentorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.hotelapplication.R
import com.example.hotelapplication.actionbar.ActionBarCustom
import com.example.hotelapplication.databinding.FragmentMainHotelBinding
import com.example.hotelapplication.databinding.FragmentPaymentOrderBinding

class PaymentOrder : Fragment() {
    private lateinit var binding: FragmentPaymentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentOrderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val actionBarRoom = ActionBarCustom.newInstance(true, "Заказ оплачен")
        openFragment(actionBarRoom, R.id.actionbar)

        binding.buttonFinishPayment.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_paymentOrder_to_mainHotel)
        }

        val randomOrder = (100000 until 900000).random()
        binding.descriptionFinishPayment.text =
            "Подтверждение заказа №$randomOrder может занять некоторое время " +
                    "(от 1 часа до суток). Как только мы получим ответ от туроператора, " +
                    "вам на почту придет уведомление."
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}