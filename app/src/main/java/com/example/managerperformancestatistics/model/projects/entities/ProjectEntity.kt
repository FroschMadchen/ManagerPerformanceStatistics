package com.example.managerperformancestatistics.model.projects.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity

@Entity(
    tableName = "projects",
)
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)val project_id:Long?,
    val access_manager_id:Int?,
    val name_project:String?,
    val description:String?,
    val status:String?,
    val image_item:Int?,
    val company_buyer:String?,
    val material:String?
)

