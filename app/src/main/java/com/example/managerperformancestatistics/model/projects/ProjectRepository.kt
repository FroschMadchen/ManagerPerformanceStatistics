package com.example.managerperformancestatistics.model.projects

import androidx.room.Query
import com.example.managerperformancestatistics.model.projects.entities.ProjectEntity
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import kotlinx.coroutines.flow.Flow

class ProjectRepository (
    private val db:AccountsDataBase
) {
    private val dao get() = db.projectDao

    fun getAll(): Flow<List<ProjectEntity>> = dao.getAll()

   suspend fun create(projectNew: ProjectEntity) = dao.createAccount(projectNew)

    suspend fun delete(project:ProjectEntity) = dao.delete(project)
}