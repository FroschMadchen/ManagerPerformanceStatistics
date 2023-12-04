package com.example.managerperformancestatistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.ActivityMainBinding
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.accounts.room.entities.AddInfoAccounts
import com.example.managerperformancestatistics.model.room.AccountsDao
import java.util.Date
lateinit var APP_ACTIVITY: MainActivity
class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    private lateinit var mNavConverter: NavController
    private lateinit var binding: ActivityMainBinding
    private val repository: AccountsDao by locateLazy()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP_ACTIVITY = this


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

    private fun createCaption(): String =
        DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()
}