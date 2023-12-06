package com.example.managerperformancestatistics.presentation

import android.app.Application
import android.content.Context
import com.example.managerperformancestatistics.MainActivity
import com.example.managerperformancestatistics.locator.ServiceLocator
import com.example.managerperformancestatistics.locator.locate
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.room.AccountsDao
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import com.example.managerperformancestatistics.model.room.AppDataBase



class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val appDatabase = AppDataBase.create(this)
        ServiceLocator.register<Context>(this)
        ServiceLocator.register<AccountsDataBase>(appDatabase)
        ServiceLocator.register(AccountsRepository(locate()))

/*
        ServiceLocator.register<Context>(this)
        ServiceLocator.register<AccountsDataBase>(AppDataBase.create(locate()))
       ServiceLocator.register(AccountsRepository(locate()))
*/

    }
}
