package com.example.managerperformancestatistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    private lateinit var mNavConverter: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //   toolbar = binding.toolbar
        mNavConverter = Navigation.findNavController(this, R.id.nav_host_fragment)
       // setSupportActionBar(toolbar)
        //title = "sdjd"
        /*   toolbar.menu
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_exit -> {
                    finish()
                    true
                }

                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }*/
    }
}