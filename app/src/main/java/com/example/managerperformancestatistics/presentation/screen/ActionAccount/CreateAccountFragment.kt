package com.example.managerperformancestatistics.presentation.screen.ActionAccount

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.MainActivity
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentCreateAccountBinding
import com.example.managerperformancestatistics.model.Account.Account
import com.example.managerperformancestatistics.presentation.screen.SignIn.AuthenticateViewModel
import com.example.managerperformancestatistics.presentation.screen.SignUp.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var PASSWORD: String

class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null
    private lateinit var mController: NavController
    private val viewModel: CreateViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCreateAccountBinding.inflate(inflater).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

        _binding?.apply {

            passwordEdit1.setOtpCompletionListener {
                PASSWORD = it.toString()
            }

            btnRegistration.setOnClickListener {
                val userName = nameUser1.text.toString()
                val email = emailEdit1.text.toString()

                Log.d("CreateAccountFragment", " password $PASSWORD")
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.saveAccount(accountNew = Account(email, userName, PASSWORD))
                    Log.d(
                        "CreateAccountFragment",
                        "DataNewAccount ($PASSWORD ) - ( $email ) - $userName"
                    )

                }
            }
        }

        _binding.apply {
            viewModel.navigationToMenu.observe(
                viewLifecycleOwner
            ) { shouldNavigation ->
                if (shouldNavigation) {
                    viewModel.onNavigationHandler()
                    findNavController().navigate(R.id.action_createAccountFragment_to_menuFragment)
                }
            }
        }
    }


    fun returnPassword(): String {
        var password = ""
        _binding?.apply {
            passwordEdit1.setOtpCompletionListener {
                password = it.toString()
            }
        }
        return password
    }
}
