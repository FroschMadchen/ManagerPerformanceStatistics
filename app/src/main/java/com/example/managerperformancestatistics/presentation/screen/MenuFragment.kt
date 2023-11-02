package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.ConcreteFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.MetalFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.StatisticFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null

    var bottom: BottomNavigationView? = null
    var frame: FrameLayout? = null
    val fragHome = ConcreteFragment()
    val fragSupp = MetalFragment()
    val fragDown = StatisticFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { binding = it }.root

    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {

            bottom?.setOnItemSelectedListener { item ->
                val transaction = childFragmentManager.beginTransaction()
                when (item.itemId) {
                    com.example.managerperformancestatistics.R.id.metal -> transaction.replace(
                        com.example.managerperformancestatistics.R.id.frameLayout, fragHome)
                    com.example.managerperformancestatistics.R.id.concrete -> transaction.replace(
                        com.example.managerperformancestatistics.R.id.frameLayout,fragSupp)
                    com.example.managerperformancestatistics.R.id.statistics -> transaction.replace(
                        com.example.managerperformancestatistics.R.id.frameLayout,fragDown, "fragDown")
                }
                transaction.commit()
                true
            }

        }
    }


}


