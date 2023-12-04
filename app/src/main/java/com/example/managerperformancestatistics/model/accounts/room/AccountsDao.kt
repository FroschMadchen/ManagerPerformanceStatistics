package com.example.managerperformancestatistics.model.room

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity
import com.example.managerperformancestatistics.model.accounts.room.entities.AddInfoAccounts
import com.example.managerperformancestatistics.model.room.Tuples.AccountsSignInTuples
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//создание
    suspend fun createAccount(accountDbEntity: AccountEntity)

    @Query("SELECT * FROM accounts WHERE id = :accountId") // получение по id
    fun getById(accountId: Long): AccountEntity

    @Query("SELECT * FROM accounts") // получить всё
    fun getAll(): Flow<List<AccountEntity?>>

    @Query("SELECT id, password FROM ACCOUNTS WHERE username =:username") // sing in
    suspend fun findByEmail(username: String): AccountsSignInTuples

    @Query("DELETE FROM accounts WHERE id = :accountId")
    suspend fun delete(accountId: Long)

    @Upsert (entity = AccountEntity::class)
    fun upsertAccounts(accounts: MutableList<AddInfoAccounts>)



    /* @Transaction
     @Query("SELECT * FROM accounts")
     fun getUsersAndLibraries(): List<UserAndProject>*/
}