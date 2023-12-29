package com.example.managerperformancestatistics.presentation.screen.Menu.BottomNavigationFrasments.metal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.dataClasses.ProjectTitle
import com.example.managerperformancestatistics.model.projects.ProjectRepository
import com.example.managerperformancestatistics.model.projects.room.entities.ProjectCreateTuples
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MetalViewModel:ViewModel() {


    private val listDB = mutableListOf<ProjectTitle>()


    private val repository: ProjectRepository by locateLazy()

    fun get(): List<ProjectTitle> = getAll()


    private fun getAll(): List<ProjectTitle> {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val listProject = repository.getAll()


                listProject.collect { projects ->
                    // Здесь вы можете обработать каждый элемент списка projects
                    for (project in projects) {
                        // Ваш код обработки
                        val projectTitle = ProjectTitle(
                            id = project.project_id?.toInt(),
                            nameProject = project.name_project,
                            nameManagerWork = project.access_manager_id.toString()
                        )
                        listDB.add(projectTitle)
                        Log.i("getAllProject","id = ${project.project_id?.toInt()} nameProject = ${project.name_project},\n" +
                                "                            nameManagerWork = ${project.access_manager_id.toString()}")
                    }
                }
                viewModelScope.launch(Dispatchers.Main) {

                }
                // Log.d("CreateViewModel", "saveAccount ${account.createdAt} -- ${account.username}")
            } catch (e: Exception) {
                Log.e("Exception", "$e")
            }
        }
        return listDB
    }

}