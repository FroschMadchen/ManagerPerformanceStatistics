package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentEntranceBinding
import com.example.managerperformancestatistics.model.room.AccountEntity

import com.example.managerperformancestatistics.presentation.viewmodel.MainViewModel

class EntranceFragment : Fragment() {
  /*  companion object{
        fun newInstance()= EntranceFragment()
    }*/
//    private val viewModel: MainViewModel by viewModels()

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
            views {
                btnRegistration.setOnClickListener {
                    // логика входа
                }
            }


        }

//        viewModel.notes.onEach(::renderAccounts).launchIn(lifecycleScope)

//        viewModel.newCaption.onEach(::renderCaption).launchIn(lifecycleScope)
}




