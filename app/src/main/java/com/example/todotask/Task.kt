package com.example.todotask

data class Task(
	val id: Int = 0,
	val userId: Int,
	val title: String,
	val description: String = "",
	val dueDate: String? = null, // بصيغة ISO 8601 مثل "2025-05-14T14:00:00Z"
	val priority: String = "low",
	val isCompleted: Boolean = false,
	val reminders: List<Reminder> = emptyList()
)
