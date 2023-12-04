package com.example.managerperformancestatistics.presentation.screen.Menu

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.managerperformancestatistics.APP_ACTIVITY
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.ConcreteFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.MetalFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.StatisticFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.ViewModelTest
import com.example.managerperformancestatistics.presentation.screen.SignIn.AuthenticateViewModel
import com.google.android.material.navigation.NavigationView


class MenuFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel: ViewModelTest by viewModels()

    private var binding: FragmentMenuBinding? = null
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private val id:Long = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { binding = it }.root

    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        views {


            val toggle = ActionBarDrawerToggle(
                requireActivity(),
                drawerLayout,
                toolbar1,
                R.string.open_nav,
                R.string.close_nav
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()


            if (savedInstanceState == null) {
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, StatisticFragment()).commit()
                //  navigationView.setCheckedItem(R.id.edit_ak_d)
            }
            /*navigationView.setNavigationItemSelectedListener {
                when(it.itemId){

                }
                true
            }*/
            binding?.bottomNavigation?.setOnItemSelectedListener { item ->

                when (item.itemId) {
                    R.id.concrete -> replaceFragment(ConcreteFragment())
                    R.id.metal -> replaceFragment(MetalFragment())
                    R.id.statistics -> replaceFragment(StatisticFragment())
                }
                true
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = (activity as AppCompatActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
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
        return when (item.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                true
            }
            R.id.remove_d -> {
                showAddListDialog(id)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showAddListDialog(id: Long) { // диалоговое окно, создание списка
        binding = FragmentMenuBinding.inflate(LayoutInflater.from(APP_ACTIVITY))
        val dialog = AlertDialog.Builder(APP_ACTIVITY)
            .setView(binding!!.root)
            .setTitle("Вы точно хотите удалить аккаунт?")
            .setPositiveButton("Да") { _, _ ->
                deleteAccount(id)
                Toast.makeText(APP_ACTIVITY,"Аккаунт удалён",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Отмена", null)
            .create()

        dialog.show()
    }
    fun deleteAccount(id:Long) = viewModel.deleteAccountVM(id)

}







