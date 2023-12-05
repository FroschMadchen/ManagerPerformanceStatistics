package com.example.managerperformancestatistics.presentation.screen.Menu

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.APP_ACTIVITY
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentMenuBinding
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.ConcreteFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.MetalFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.StatisticFragment
import com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.ViewModelTest
import com.example.managerperformancestatistics.presentation.screen.SignIn.AuthenticateViewModel
import com.example.managerperformancestatistics.presentation.screen.SignIn.ID
import com.example.managerperformancestatistics.presentation.screen.SignIn.NAMEUSER
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationView


class MenuFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel: ViewModelTest by viewModels()

    private var _binding: FragmentMenuBinding? = null
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var mController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMenuBinding.inflate(inflater).also { _binding = it }.root

    private fun <T> views(block: FragmentMenuBinding.() -> T): T? = _binding?.block()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

        val headerView = navigationView.getHeaderView(0)
        val textView = headerView.findViewById<TextView>(R.id.user_name)
        textView.text = NAMEUSER


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
            }
            navigationView.setNavigationItemSelectedListener {

                when (it.itemId) {
                    R.id.remove_d -> {
                        showAddListDialog(ID)
                        Log.d("setNavigationItemSelectedListener", "Remove button clicked")
                        findNavController().navigate(R.id.action_menuFragment_to_entranceFragment)
                        true
                    }

                    R.id.edit_ak_d -> {
                        findNavController().navigate(R.id.action_menuFragment_to_editAccountFragment)
                        true
                    }

                    R.id.create_user -> {
                        findNavController().navigate(R.id.action_menuFragment_to_createAccountFragment)
                        true
                    }

                    else -> {
                        true
                    }
                }
            }
            _binding?.bottomNavigation?.setOnItemSelectedListener { item ->

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
        return when (item.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    Log.d("onNavigationItemSelected","DrawerOpen")
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                true
            }
            else -> {
                return false
            }
        }
    }

 /*   fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }*/

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    Log.d("onOptionsItemSelected","DrawerOpen")
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAddListDialog(id: Long) { // диалоговое окно, создание списка
        _binding = FragmentMenuBinding.inflate(LayoutInflater.from(APP_ACTIVITY))
        val dialog = AlertDialog.Builder(APP_ACTIVITY)
            .setView(_binding!!.root)
            .setTitle("Вы точно хотите удалить аккаунт?")
            .setPositiveButton("Да") { _, _ ->
                deleteAccount(id)
                Toast.makeText(APP_ACTIVITY, "Аккаунт удалён", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Отмена", null)
            .create()

        dialog.show()
    }

    private fun deleteAccount(id: Long) = viewModel.deleteAccountVM(id)

}







