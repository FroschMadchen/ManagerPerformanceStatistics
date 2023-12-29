package com.example.managerperformancestatistics.model.projects

import android.content.Context
import androidx.room.Query
import com.example.managerperformancestatistics.model.projects.entities.ProjectEntity
import com.example.managerperformancestatistics.model.projects.room.ProjectsDao
import com.example.managerperformancestatistics.model.room.AccountsDataBase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class ProjectRepository (
  //  private val projectsDao: ProjectsDao,
    //private val ioDispatcher: CoroutineDispatcher,
    private val db:AccountsDataBase, // new
 //   val context: Context //new
) {
   private val dao get() = db.projectDao

    fun getAll(): Flow<List<ProjectEntity>> = dao.getAll()

   suspend fun create(projectNew: ProjectEntity) = dao.createAccount(projectNew)

    suspend fun delete(project:ProjectEntity) = dao.delete(project)
}