package com.example.managerperformancestatistics.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch

class AuthenticateViewModel : ViewModel() {
    private val _navigateToMenu = MutableLiveData<Boolean>()
    val navigationToMenu: LiveData<Boolean>
        get() = _navigateToMenu

    private val repository: AccountsRepository by locateLazy()


    val notes = repository.getAll().asLiveDataFlow()
    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)


    fun authenticateUser(username: String, password: String) {
        try {
            viewModelScope.launch(Dispatchers.IO) {

                val user = repository.findByEmail(username)
                if (password == user.password) {
                    viewModelScope.launch(Dispatchers.Main) {
                        _navigateToMenu.value = true
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("Exception", "${e.toString()}")
        }


    }

    fun onNavigationHandler() {
        _navigateToMenu.value = false
    }
}

