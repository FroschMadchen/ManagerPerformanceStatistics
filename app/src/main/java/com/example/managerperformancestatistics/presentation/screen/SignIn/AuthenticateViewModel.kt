package com.example.managerperformancestatistics.presentation.screen.SignIn

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

var ID by Delegates.notNull<Long>()
var NAMEUSER by Delegates.notNull<String>()

class AuthenticateViewModel : ViewModel() {
    private val _navigateToMenu = MutableLiveData<Boolean>()
    val navigationToMenu: LiveData<Boolean>
        get() = _navigateToMenu

    private val repository: AccountsRepository by locateLazy()

    // val notes = repository.getAll().asLiveDataFlow()
    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)

    @SuppressLint("SuspiciousIndentation")
    fun authenticateUser(username: String, password: String) {
        Log.d("authenticateUser", "password wrong $password  $username")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = repository.findByEmail(username)

                if (user == null) {
                    viewModelScope.launch(Dispatchers.Main) {
                        _navigateToMenu.value = false
                    }
                } else {
                    // Теперь user не null, можно использовать его методы
                    Log.d("authenticateUser", "password wrong ${user.password}")

                    if (user.password == null) {
                        // Пароль пользователя тоже null
                        viewModelScope.launch(Dispatchers.Main) {
                            _navigateToMenu.value = false
                        }
                    } else if (password == user.password) {
                        // Всё в порядке, пароль совпадает
                        ID = user.id
                        NAMEUSER = username
                        viewModelScope.launch(Dispatchers.Main) {
                            _navigateToMenu.value = true
                        }
                    } else {
                        // Неправильный пароль
                        viewModelScope.launch(Dispatchers.Main) {
                            Log.d("authenticateUser", "password wrong")
                            _navigateToMenu.value = false
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("Exception", "$e")
            }
        }
    }

    fun onNavigationHandler() {
        _navigateToMenu.value = false
    }
}

