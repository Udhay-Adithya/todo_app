package com.udhay.todo.data.repository

import com.udhay.todo.data.local.dao.TodoDao
import com.udhay.todo.data.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    fun getAllTodos() : Flow<List<TodoEntity>> = todoDao.getAllTodos()

    suspend fun insertTodo(todo : TodoEntity) = todoDao.insertTodo(todo)

    suspend fun updateTodo(todo: TodoEntity) = todoDao.updateTodo(todo)

    suspend fun deleteTodo(todo: TodoEntity) = todoDao.deleteTodo(todo)
}