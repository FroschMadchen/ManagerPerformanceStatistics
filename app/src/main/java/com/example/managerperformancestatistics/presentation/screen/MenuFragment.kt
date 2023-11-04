package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.ActivityMainBinding

import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.ConcreteFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.MetalFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.StatisticFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { binding = it }.root



    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views{
            (activity as AppCompatActivity).supportActionBar?.title = "Shopping List"
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }
        replaceFragment(StatisticFragment())

        views {

            binding?.bottomNavigation?.setOnItemSelectedListener { item ->

                when (item.itemId) {
                    R.id.concrete -> replaceFragment(ConcreteFragment())
                    R.id.metal -> replaceFragment(MetalFragment())
                    R.id.statistics -> replaceFragment(StatisticFragment())

                    else ->{

                    }
                }
                true
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}






