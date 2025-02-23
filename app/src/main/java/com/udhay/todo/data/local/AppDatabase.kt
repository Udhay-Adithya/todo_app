package com.udhay.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.udhay.todo.data.local.dao.TodoDao
import com.udhay.todo.data.local.entity.TodoEntity


@Database(entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao
}