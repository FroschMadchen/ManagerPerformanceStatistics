package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.ConcreteFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.MetalFragment
import com.example.managerperformancestatistics.presentation.screen.BottomNavigationFrasments.StatisticFragment
import com.google.android.material.navigation.NavigationView


class MenuFragment : Fragment(),NavigationView.OnNavigationItemSelectedListener {

    private var binding: FragmentMenuBinding? = null
    private lateinit var mToolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { binding = it }.root
    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {


            mToolbar = binding!!.toolbar1

            (activity as AppCompatActivity).setSupportActionBar(mToolbar)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

            val toggle = ActionBarDrawerToggle(
                requireActivity(),
                drawerLayout,
                mToolbar,
                R.string.open_nav,
                R.string.close_nav
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()


            if (savedInstanceState == null) {
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, StatisticFragment()).commit()
                navigationView.setCheckedItem(R.id.edit_ak_d)
            }



            navigationView.setNavigationItemSelectedListener {
                when(it.itemId){

                }
                true
            }

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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

   fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}







