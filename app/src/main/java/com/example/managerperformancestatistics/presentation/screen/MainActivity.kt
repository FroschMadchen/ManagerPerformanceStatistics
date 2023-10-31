package com.example.managerperformancestatistics.presentation.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mNavConverter: NavController
    private var _binding: ActivityMainBinding? = null
    val mBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
       /* if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EntranceFragment.newInstance())
                .commitNow()
        }*/
        mNavConverter = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}