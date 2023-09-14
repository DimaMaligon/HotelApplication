package com.example.hotelapplication.actionbar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.databinding.FragmentActionBarCustomBinding

class ActionBarCustom(val arrow: Boolean, val title: String) : Fragment() {
    private lateinit var binding: FragmentActionBarCustomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActionBarCustomBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            if (!arrow) {
                backButton.visibility = View.INVISIBLE
            }else{
                backButton.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
            titleBar.text = title
        }
    }

    companion object {
        fun newInstance(arrow: Boolean, title: String) = ActionBarCustom(arrow, title)
    }
}