package com.example.managerperformancestatistics.model.Account

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Account(
   val email: String,
    val username: String,
    val password: String,
)
