package com.example.managerperformancestatistics

import android.content.Context


import androidx.room.Room
import com.example.managerperformancestatistics.model.accounts.AccountsRepository

import com.example.managerperformancestatistics.model.room.AccountsDataBaseImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


object Repository {
/*

        private lateinit var applicationContext: Context

        // -- stuffs

        private val database: AccountsDataBaseImpl by lazy<AccountsDataBaseImpl> {
            Room.databaseBuilder(applicationContext, AccountsDataBaseImpl::class.java, "accounts_db")
                .createFromAsset("initial_database.db")
                .build()
        }

        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

*/


        // --- repositories

    /*  val accountsRepository: AccountsRepository by lazy {
            AccountsRepository(database.getAccountsDao(),)
        }*/

       /* val boxesRepository: BoxesRepository by lazy {
            RoomBoxesRepository(accountsRepository, database.getBoxesDao(), ioDispatcher)
        }
*/
        /**
         * Call this method in all application components that may be created at app startup/restoring
         * (e.g. in onCreate of activities and services)
         */
    /*    fun init(context: Context) {
            applicationContext = context
        }*/
    }


