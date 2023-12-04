package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelTest : ViewModel() {

    private val _navigateToMenu = MutableLiveData<Boolean>()
    val navigationToMenu: LiveData<Boolean>
        get() = _navigateToMenu

    private val repository: AccountsRepository by locateLazy()


    fun deleteAccountVM(id: Long) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                repository.delete(id)
                viewModelScope.launch(Dispatchers.Main) {
                    _navigateToMenu.value = true
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