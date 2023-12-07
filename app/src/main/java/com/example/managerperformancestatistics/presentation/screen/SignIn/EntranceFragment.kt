package com.example.managerperformancestatistics.presentation.screen.SignIn

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentEntranceBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val NUMBER: Int = 6

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

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()

        _binding?.apply {


            viewModel.navigationToMenu.observe(
                viewLifecycleOwner,
                Observer { shouldNavigation ->
                    if (shouldNavigation) {
                        viewModel.onNavigationHandler()
                        findNavController().navigate(R.id.action_entranceFragment_to_menuFragment)
                    } else {
                        Log.d("observe", "password wrong")
                        val backgroundDrawable =
                            ContextCompat.getDrawable(
                                requireActivity(),
                                R.drawable.box_edit_text_error
                            )

                        _binding?.apply {
                            passwordEdit.setItemBackground(backgroundDrawable)
                            passwordText.text = "Неверный пароль"
                            passwordText.setTextColor(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.Red_text
                                )
                            )
                        }

                    }
                })


            _binding?.apply {


                var password = ""
                passwordEdit.setOtpCompletionListener {
                    password = it.toString()
                }


                passwordEdit.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {
                        // Не используется
                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        password = s.toString()


                        Log.i(
                            "getNumberFun_FEN",
                            "${password.length} : $password  ${password.count()}"
                        )

                        if (password.length >= NUMBER) {
                            btnEntrance.isEnabled = true
                            btnEntrance.background.setTint(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.backgrund
                                )
                            )
                        }
                    }

                    override fun afterTextChanged(s: Editable?) {
                        // Не используется
                    }
                })

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

    override fun onStart() {
        super.onStart()
        Log.d("onStart", "onStart")
        _binding?.apply {

            val backgroundDrawable =
                ContextCompat.getDrawable(requireActivity(), R.drawable.box_edit_text)
            passwordEdit.setItemBackground(backgroundDrawable)


            btnEntrance.isEnabled = false
            btnEntrance.background.setTint(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.button_enabled
                )
            )
            passwordEdit.setText("")

        }
    }

}











