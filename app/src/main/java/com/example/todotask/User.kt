package com.example.todotask

data class User(
	val id: Int = 0,
	val name: String,
	val email: String,
	val password: String,
	val tasks: List<Task> = emptyList()
)

