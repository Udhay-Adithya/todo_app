package com.udhay.todo.ui.component


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udhay.todo.data.local.entity.TodoEntity


@Composable
fun EditTodoDialog(
    todo: TodoEntity,
    onUpdate: (TodoEntity) -> Unit,
    onDismiss: () -> Unit
) {
    // Local state for edited values
    var editedTitle by remember { mutableStateOf(todo.title) }
    var editedDescription by remember { mutableStateOf(todo.description) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Edit Todo") },
        text = {
            Column(modifier = Modifier.padding(8.dp)) {
                TextField(
                    value = editedTitle,
                    onValueChange = { editedTitle = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = editedDescription,
                    onValueChange = { editedDescription = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val updatedTodo = todo.copy(
                        title = editedTitle,
                        description = editedDescription
                    )
                    onUpdate(updatedTodo)
                    onDismiss()
                }
            ) { Text("Save") }
        },
        dismissButton = {
            Button(onClick = onDismiss) { Text("Cancel") }
        }
    )
}