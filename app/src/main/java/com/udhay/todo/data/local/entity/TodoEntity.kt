package com.udhay.todo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "description") val description : String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "priority") val priority : Int,
    @ColumnInfo(name = "is_completed") val isCompleted : Boolean = false,
    @ColumnInfo(name = "created_at") val createdAt : Long = System.currentTimeMillis(),
    )
