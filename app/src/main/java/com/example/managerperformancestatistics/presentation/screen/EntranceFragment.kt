package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import android.util.Log
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentEntranceBinding
import com.example.managerperformancestatistics.presentation.viewmodel.AuthenticateViewModel

import com.example.managerperformancestatistics.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EntranceFragment : Fragment() {
  /*  companion object{
        fun newInstance()= EntranceFragment()
    }*/
    private val viewModel: AuthenticateViewModel by viewModels()

    private var binding:FragmentEntranceBinding? = null
    lateinit var mController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = FragmentEntranceBinding.inflate(inflater).also { binding = it }.root
        private fun <T> views(block: FragmentEntranceBinding.() -> T): T? = binding?.block()



        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            mController = findNavController()

            views {
             btnRegistration.setOnClickListener{
                    mController.navigate(R.id.action_entranceFragment_to_registrationFragment)
             }
            }

            viewModel.navigationToMenu.observe(viewLifecycleOwner, Observer { shouldNavigation ->
                if(shouldNavigation){
                    viewModel.onNavigationHandler()
                    findNavController().navigate(R.id.action_entranceFragment_to_menuFragment)
                }
            })

            views{
                btnEntrance.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.authenticateUser(
                            username = loginEdit.text.toString(),
                            password = passwordEdit.text.toString()
                        )
                    }
                }
            }

       /*     views {
                btnEntrance.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        val success = viewModel.authenticateUser(
                            username = loginEdit.text.toString(),
                            password = passwordEdit.text.toString()
                        )
                        withContext(Dispatchers.Main){
                            Log.i("authenticateUser",   "$success")
                            if (success){
                                Log.i("action_entranceFragment_to_menuFragment",   "$success")
                                mController.navigate(R.id.action_entranceFragment_to_menuFragment)
                            }
                        }
                    }
                }
            }*/
        }

//        viewModel.notes.onEach(::renderAccounts).launchIn(lifecycleScope)

//        viewModel.newCaption.onEach(::renderCaption).launchIn(lifecycleScope)
}




