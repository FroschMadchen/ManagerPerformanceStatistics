package com.example.managerperformancestatistics.model.projects.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity
import com.example.managerperformancestatistics.model.projects.entities.ProjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProjectsDao {
    @Query("SELECT * FROM projects")
    fun getAll():Flow<List<ProjectEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )//создание
    suspend fun createAccount(project: ProjectEntity)

    @Delete
    suspend fun delete(account: ProjectEntity):Unit


}