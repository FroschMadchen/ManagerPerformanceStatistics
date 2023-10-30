package com.example.managerperformancestatistics.presentation

import android.app.Application
import android.content.Context
import com.example.managerperformancestatistics.locator.ServiceLocator
import com.example.managerperformancestatistics.locator.locate
import com.example.managerperformancestatistics.model.AccountsRepository
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import com.example.managerperformancestatistics.model.room.AccountsDataBaseImpl

class App:Application() {

        override fun onCreate() {
            super.onCreate()

            ServiceLocator.register<Context>(this)
            ServiceLocator.register<AccountsDataBase>(AccountsDataBaseImpl.create(locate()))
            ServiceLocator.register(AccountsRepository(locate()))
        }
    }
