package com.example.managerperformancestatistics.model.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface AccountsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE ) //создание
    suspend fun createAccount(accountDbEntity: AccountEntity)

    @Query("SELECT * FROM accounts WHERE id = :accountId") // получение по id
    fun getById(accountId: Long): AccountEntity

    @Query("SELECT * FROM accounts") // получить всё
    fun getAll(): Flow<List<AccountEntity?>>

    @Delete
    suspend fun delete(account: AccountEntity):Unit
}