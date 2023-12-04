package com.example.managerperformancestatistics

import android.content.Context
import androidx.room.Room
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.projects.ProjectRepository
import com.example.managerperformancestatistics.model.room.AppDataBase
import com.example.managerperformancestatistics.model.room.MIGRATION_1_2
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object Repositories {

/*    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: AppDataBase by lazy<AppDataBase> {
        Room.databaseBuilder(applicationContext, AppDataBase::class.java, "database.db")
            .createFromAsset("data.db")
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    // --- repositories

   val accountsRepository: AccountsRepository by lazy {
        AccountsRepository(database.getAccountsDao(), ioDispatcher)
    }

    val projectRepository: ProjectRepository by lazy {
        ProjectRepository(database.getProjectDao(), ioDispatcher)
    }

    *//**
     * Call this method in all application components that may be created at app startup/restoring
     * (e.g. in onCreate of activities and services)
     *//*
    fun init(context: Context) {
        applicationContext = context
    }*/
}