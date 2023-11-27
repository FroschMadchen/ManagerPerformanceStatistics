package com.example.managerperformancestatistics.presentation.screen.SignIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentEntranceBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EntranceFragment : Fragment() {

    private val viewModel: AuthenticateViewModel by viewModels()
    private var _binding: FragmentEntranceBinding? = null
    private lateinit var mController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View = FragmentEntranceBinding.inflate(inflater).also { _binding = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

        _binding.apply {

            viewModel.navigationToMenu.observe(
                viewLifecycleOwner,
                Observer { shouldNavigation ->
                    if (shouldNavigation) {
                        viewModel.onNavigationHandler()
                        findNavController().navigate(R.id.action_entranceFragment_to_menuFragment)
                    }
                })
            _binding?.apply {
                var password = ""
                passwordEdit.setOtpCompletionListener {
                    password = it.toString()
                }
                btnEntrance.setOnClickListener {
                    CoroutineScope(Dispatchers.IO).launch {
                        viewModel.authenticateUser(
                            username = loginEdit.text.toString(),
                            password = password
                        )
                    }
                }
            }
        }
    }
}




