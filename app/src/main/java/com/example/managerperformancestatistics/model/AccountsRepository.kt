package com.example.managerperformancestatistics.model

import com.example.managerperformancestatistics.model.room.AccountEntity
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import kotlinx.coroutines.flow.Flow

class AccountsRepository(
    private val db:AccountsDataBase
) {
    private val dao get() = db.accountsDao
    fun getAll(): Flow<List<AccountEntity?>> = dao.getAll()
    fun getById(id:Long): AccountEntity = dao.getById(accountId =id )
    suspend fun delete(account: AccountEntity) = dao.delete(account)
    suspend fun createAccount(account: AccountEntity) = dao.createAccount(account)
}
