package com.example.todotask

data class TaskRequest(
	val userId: Int,
	val title: String,
	val description: String,
	val dueDate: String?, // بصيغة ISO 8601 مثل "2025-05-14T18:00:00Z"
	val priority: String,
	val isCompleted: Boolean = false
)
