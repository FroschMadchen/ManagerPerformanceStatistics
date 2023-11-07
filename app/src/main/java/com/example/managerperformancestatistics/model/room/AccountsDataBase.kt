package com.example.managerperformancestatistics.model.room

import com.example.managerperformancestatistics.model.projects.room.ProjectsDao

interface AccountsDataBase {
    val accountsDao:AccountsDao
    val projectDao:ProjectsDao
}
/*в этом интерфейсе,предоставляею способ для получения доступа к
 объекту DAO моей базы данных через реализующий класс,
 в будущем добавлю второй DAO  с  projects
 */