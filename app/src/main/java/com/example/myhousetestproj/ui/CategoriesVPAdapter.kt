package com.example.myhousetestproj.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myhousetestproj.ui.content.CamerasFragment
import com.example.myhousetestproj.ui.content.DoorsFragment

class CategoriesVPAdapter(
    fm: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fm, lifecycle) {
    private val content = listOf<Fragment>(
        CamerasFragment(),
        DoorsFragment()
    )

    override fun getItemCount(): Int {
        return content.size
    }

    override fun createFragment(position: Int): Fragment {
        return content[position]
    }
}