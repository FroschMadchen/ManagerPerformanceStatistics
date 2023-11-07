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

/*@Database(
    entities = [
        AccountEntity::class,
        ProjectEntity::class
    ], version = 1
)
abstract class AccountsDataBaseImpl1:RoomDatabase(),AccountsDataBase {

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            AccountsDataBaseImpl1::class.java,
            "accounts_db"
        ).build()
    }
}*/

// Database class after the version update.
@Database(
    version = 2,
    entities = [
        AccountEntity::class,
        ProjectEntity::class
               ],
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]
)
abstract class AccountsDataBaseImpl:RoomDatabase(),AccountsDataBase {


    companion object {
        private const val DATABASE_NAME = "accounts_db"

        fun create(context: Context): AccountsDataBaseImpl {
            return Room.databaseBuilder(context, AccountsDataBaseImpl::class.java, DATABASE_NAME)
                .addMigrations(MIGRATION_1_2) // Добавьте миграции
                .build()
        }
    }
}

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS projects(  name_project TEXT, material TEXT,project_id INTEGER PRIMARY KEY AUTOINCREMENT,access_manager_id INTEGER,description TEXT,image_item INTEGER,company_buyer TEXT,status TEXT)")
        // Здесь опишите миграцию для обновления базы данных с версии 1 до версии 2. // description TEXT,status TEXT,image_item INTEGER,company_buyer TEXT,
        // Например, ALTER TABLE или создание новых таблиц.
    }
}

