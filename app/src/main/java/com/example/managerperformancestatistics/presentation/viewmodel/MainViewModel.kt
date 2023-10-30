package com.example.managerperformancestatistics.presentation.viewmodel

import android.text.format.DateFormat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.AccountsRepository
import com.example.managerperformancestatistics.model.room.AccountEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel: ViewModel() {

    private val repository: AccountsRepository by locateLazy()


    val notes = repository.getAll().asLiveDataFlow()
    val newCaption = flow<String> {
        while (true) {
            emit(createCaption())
            delay(500L)
        }
    }

    fun saveAccount(account: AccountEntity) {
            viewModelScope.launch { repository.createAccount(account =account ) }
        }

    fun delete(account: AccountEntity) {
        viewModelScope.launch { repository.delete(account =account ) }
    }

    private fun createAccount(account: AccountEntity) = AccountEntity(
        id = account.id,
        email = account.email,
        username = account.username,
        password = account.password,
        createdAt = createCaption()
    )

    private fun createCaption(): String =
        DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()
    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
}
