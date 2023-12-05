package com.example.managerperformancestatistics.presentation.screen.ActionAccount

import android.text.format.DateFormat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.Account.Account
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn

class CreateViewModel : ViewModel() {

    private val _navigateToMenu = MutableLiveData<Boolean>()
    val navigationToMenu: LiveData<Boolean>
        get() = _navigateToMenu

    private val repository: AccountsRepository by locateLazy()

    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
    fun saveAccount(accountNew: Account) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val account = createAccount(accountNew = accountNew)
                repository.createAccount(account = account)
                viewModelScope.launch(Dispatchers.Main) {
                    _navigateToMenu.value = true
                }
                Log.d("CreateViewModel", "saveAccount ${account.createdAt} -- ${account.username}")
            } catch (e: Exception) {
                Log.e("Exception", "$e")
            }
        }

    }


    private fun createAccount(accountNew: Account): AccountEntity = AccountEntity(
        id = 0,
        email = accountNew.email,
        username = accountNew.username,
        password = accountNew.password,
        createdAt = createCaption()
    )

    private fun createCaption(): String =
        DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()

    fun onNavigationHandler() {
        _navigateToMenu.value = false
    }
}