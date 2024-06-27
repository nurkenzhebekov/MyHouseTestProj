package com.example.myhousetestproj.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myhousetestproj.databinding.FragmentMyHouseBinding
import com.google.android.material.tabs.TabLayoutMediator

class MyHouseFragment : Fragment() {

    private var _binding: FragmentMyHouseBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CategoriesVPAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyHouseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }

    private fun setup() {
        adapter = CategoriesVPAdapter(fm = childFragmentManager, lifecycle)
        binding.vpCategories.adapter = adapter

        TabLayoutMediator(binding.tblCategories, binding.vpCategories) { tab, position ->
            tab.text = when (position) {
                0 -> "Камеры"
                1 -> "Двери"
                else -> error("position not supported")
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}