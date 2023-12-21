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
import kotlinx.coroutines.launch
import java.util.Date

class CreateProjectVM : ViewModel() { // 21.12.2023

    private val createProject = MutableLiveData<Boolean>()
    val createProjectMutable: LiveData<Boolean>
        get() = createProjectMutable

    private val repository: ProjectRepository by locateLazy()

    fun createProject(newProject: ProjectCreateTuples) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                repository.create(
                    projectNew = ProjectEntity(
                        access_manager_id = newProject.access_manager_id,
                        name_project = newProject.name_project,
                        description = newProject.description,
                        status = newProject.status,
                        image_item = newProject.image_item,
                        company_buyer = newProject.company_buyer,
                        material = newProject.material,
                        project_id = 0
                    )
                )
                viewModelScope.launch(Dispatchers.Main) {
                    createProject.value = true
                }
                Log.d("CreateViewModel", "saveAccount ${newProject.name_project} -- ${newProject.access_manager_id}")
            } catch (e: Exception) {
                Log.e("Exception", "$e")
            }
        }

    }
}