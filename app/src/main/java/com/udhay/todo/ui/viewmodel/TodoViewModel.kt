package com.udhay.todo.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udhay.todo.data.local.entity.TodoEntity
import com.udhay.todo.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) : ViewModel() {
    val todos = todoRepository.getAllTodos().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun addTodo(title: String, description: String, category: String, priority: Int) {
        viewModelScope.launch {
            todoRepository.addTodo(
                TodoEntity(
                    title = title,
                    description = description,
                    category = category,
                    priority = priority
                ),
            )

        }
    }

    fun updateTodo(todo: TodoEntity){
        viewModelScope.launch {
            todoRepository.updateTodo(todo)

        }
    }

    fun deleteTodo(todo: TodoEntity){
        viewModelScope.launch {
            todoRepository.deleteTodo(todo)
        }
    }
}