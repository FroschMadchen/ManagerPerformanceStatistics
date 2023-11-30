package com.example.managerperformancestatistics.model.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.managerperformancestatistics.model.accounts.room.entities.AccountEntity
import com.example.managerperformancestatistics.model.projects.entities.ProjectEntity

@Database(
    version = 2,
    entities = [
        AccountEntity::class,
        ProjectEntity::class
    ],
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class AccountsDataBaseImpl : RoomDatabase(), AccountsDataBase {

    companion object {
        private const val DATABASE_NAME = "accounts_db"

        fun create(context: Context): AccountsDataBaseImpl {
            return Room.databaseBuilder(context, AccountsDataBaseImpl::class.java, DATABASE_NAME)
                .addMigrations(MIGRATION_1_2)
                .build()
        }
    }
}

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS projects(  name_project TEXT, material TEXT,project_id INTEGER PRIMARY KEY AUTOINCREMENT,access_manager_id INTEGER,description TEXT,image_item INTEGER,company_buyer TEXT,status TEXT)")
    }
}

