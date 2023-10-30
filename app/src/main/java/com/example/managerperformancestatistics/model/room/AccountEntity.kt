package com.example.managerperformancestatistics.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ]
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val email: String,// <-
    // SQLite должен рассматривать данные в столбце email без учёта
    // регистра символов при выполнении операций сравнения и сортировки.
    val username: String,
    val password: String,
    @ColumnInfo(name = "create_at") val createdAt: String
)