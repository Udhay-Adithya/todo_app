package com.udhay.todo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.udhay.todo.data.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM todos ORDER BY created_at DESC")
    fun getAllTodos() : Flow<List<TodoEntity>>

    @Insert
    suspend fun insertTodo(todo : TodoEntity)

    @Update
    suspend fun updateTodo(todo : TodoEntity)

    @Delete
    suspend fun deleteTodo(todo :TodoEntity)
}