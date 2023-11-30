package com.example.managerperformancestatistics.model.accounts

import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import kotlinx.coroutines.flow.Flow

class AccountsRepository(
    private val db:AccountsDataBase
) {
    private val dao get() = db.accountsDao
    fun getAll(): Flow<List<AccountEntity?>> = dao.getAll()
    fun getById(id:Long): AccountEntity = dao.getById(accountId =id )
    suspend fun delete(account: Long) = dao.delete(account)
    suspend fun createAccount(account: AccountEntity) = dao.createAccount(account)

    suspend fun findByEmail(username:String) = dao.findByEmail(username)
 /*  suspend fun  authenticateUser(username:String, password:String,email:String):Boolean {
        val user = dao.findByEmail(email)
       return password == user.password
   }*/
}
