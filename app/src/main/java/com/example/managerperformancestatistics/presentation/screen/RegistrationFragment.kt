package com.example.managerperformancestatistics.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.managerperformancestatistics.R
import com.example.managerperformancestatistics.databinding.FragmentRegistrationBinding
import com.example.managerperformancestatistics.model.Account.Account
import com.example.managerperformancestatistics.model.room.AccountEntity
import com.example.managerperformancestatistics.presentation.viewmodel.MainViewModel

class RegistrationFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var binding: FragmentRegistrationBinding? = null
    lateinit var mController:NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentRegistrationBinding.inflate(inflater).also { binding = it }.root
    private fun <T> views(block: FragmentRegistrationBinding.() -> T): T? = binding?.block()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mController = findNavController()
        views{
            (activity as AppCompatActivity).supportActionBar?.title = "Shopping List"
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        }

        views {
            btnRegistration.setOnClickListener{
                val username = usernameEdit.text.toString()/*.takeIf { it.isNotEmpty() }?: return@setOnClickListener*/
                val email = emailEdit.text.toString()
                val password = passwordEdit.text.toString()
                if(username.isNotEmpty()||email.isNotEmpty()||password.isNotEmpty()){
                    viewModel.saveAccount(Account(email,username,password))
                    mController.navigate(R.id.action_registrationFragment_to_menuFragment)
                } else{
                    Toast.makeText(
                        requireActivity(),
                        "Нельзя оставлять поле пустым!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                usernameEdit.text.clear()
                emailEdit.text.clear()
                passwordEdit.text.clear()

            }
        }


    }

//    viewModel.notes.onEach(::renderAccounts).launchIn(lifecycleScope)

//        viewModel.newCaption.onEach(::renderCaption).launchIn(lifecycleScope)
}

private fun saveNote() {
//    views {
//        val noteText = addNoteEditText.text.toString().takeIf { it.isNotBlank() } ?: return@views
//
//        viewModel.save(noteText)
//
//        addNoteEditText.setText("")
//    }
}

private fun renderCaption(caption: String) {
//        views { captionTextView.text = caption }
}

private fun renderAccounts(notes: List<AccountEntity>) {
//        adapter?.submitList(notes)
}

