package com.example.managerperformancestatistics.model.projects.room.entities

data class ProjectCreateTuples(
    val access_manager_id: Int,
    val name_project: String,
    val description: String,
    val status: String,
    val image_item: Int,
    val company_buyer: String,
    val material: String
)
