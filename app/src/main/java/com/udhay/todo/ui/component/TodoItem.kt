package com.udhay.todo.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udhay.todo.data.local.entity.TodoEntity

@Composable
fun TodoItem(todo: TodoEntity, onUpdate: (TodoEntity) -> Unit, onDelete: (TodoEntity) -> Unit) {
    var isEditing by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (isEditing) {
                EditTodoDialog(
                    todo = todo,
                    onUpdate = onUpdate,
                    onDismiss = { isEditing = false }
                )
            } else {
                Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
                Text(text = todo.description, style = MaterialTheme.typography.bodyMedium)
                Row {
                    Checkbox(
                        checked = todo.isCompleted,
                        onCheckedChange = { checked ->
                            onUpdate(todo.copy(isCompleted = checked))
                        }
                    )
                    IconButton(onClick = { isEditing = true }) {
                        Icon(Icons.Default.Edit, "Edit")
                    }
                    IconButton(onClick = { onDelete(todo) }) {
                        Icon(Icons.Default.Delete, "Delete")
                    }
                }
            }
        }
    }
}