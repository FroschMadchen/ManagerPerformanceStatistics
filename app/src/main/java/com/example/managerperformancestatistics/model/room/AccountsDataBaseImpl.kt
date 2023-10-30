package com.example.managerperformancestatistics.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [
        AccountEntity::class
    ], version = 1
)
abstract class AccountsDataBaseImpl:RoomDatabase(),AccountsDataBase {

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            AccountsDataBaseImpl::class.java,
            "accounts_db"
        ).build()
    }
}