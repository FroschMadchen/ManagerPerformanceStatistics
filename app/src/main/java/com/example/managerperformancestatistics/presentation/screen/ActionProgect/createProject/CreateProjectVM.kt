package com.example.managerperformancestatistics.presentation.screen.ActionProgect.createProject

import android.text.format.DateFormat
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.managerperformancestatistics.locator.locateLazy
import com.example.managerperformancestatistics.model.accounts.AccountsRepository
import com.example.managerperformancestatistics.model.projects.ProjectRepository
import com.example.managerperformancestatistics.model.projects.entities.ProjectEntity
import com.example.managerperformancestatistics.model.projects.room.entities.ProjectCreateTuples
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.Date

class CreateProjectVM : ViewModel() { // 21.12.2023

    private val createProject = MutableLiveData<Boolean>()
    val createProjectMutable: LiveData<Boolean>
        get() = createProject

    private val repository: ProjectRepository by locateLazy()

    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)


    fun createProject(newProject: ProjectCreateTuples) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.i("createProjectvm", "${newProject.company_buyer}, ${newProject.status}")
                val project = createProject1(newProject)
                repository.create(project)
                /*  repository.create(
                      projectNew = ProjectEntity(
                          0,
                          access_manager_id = newProject.access_manager_id,
                          name_project = newProject.name_project,
                          description = newProject.description,
                          status = newProject.status,
                          image_item = newProject.image_item,
                          company_buyer = newProject.company_buyer,
                          material = newProject.material
                      )
                  )*/
                Log.i(
                    "createProjectVM",
                    "${newProject.company_buyer}, ${newProject.status}!!!!!!!!!"
                )
                viewModelScope.launch(Dispatchers.Main) {
                    createProject.value = true
                }
                Log.d(
                    "CreateViewModel",
                    "saveAccount ${newProject.name_project} -- ${newProject.access_manager_id}"
                )
            } catch (e: Exception) {
                Log.e("Exception View Model CREATE PROJECT", "$e")
            }
        }

    }

    private fun createProject1(newProject: ProjectCreateTuples): ProjectEntity = ProjectEntity(

        access_manager_id = newProject.access_manager_id,
        name_project = newProject.name_project,
        description = newProject.description,
        status = newProject.status,
        image_item = newProject.image_item,
        company_buyer = newProject.company_buyer,
        material = newProject.material,
        project_id = null
    )


    fun onNavigationHandler() {
        createProject.value = false
    }


}

