package com.example.todotask

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

	// ---------- Users ----------
	@GET("users")
	fun getUsers(): Call<List<User>>

	@POST("users")
	fun createUser(@Body user: User): Call<User>

	// ---------- Tasks ----------
	@GET("tasks")
	fun getTasks(): Call<List<Task>>

	@GET("users/{userId}/tasks")
	fun getTasksByUser(@Path("userId") userId: Int): Call<List<Task>>

	@POST("tasks")
	fun createTask(@Body request: TaskRequest): Call<Task>

	@PUT("tasks/{id}")
	fun updateTask(@Path("id") id: Int, @Body request: TaskRequest): Call<Task>

	@DELETE("tasks/{id}")
	fun deleteTask(@Path("id") id: Int): Call<Void>

	// ---------- Reminders ----------
	@GET("tasks/{taskId}/reminders")
	fun getReminders(@Path("taskId") taskId: Int): Call<List<Reminder>>

	@POST("reminders")
	fun createReminder(@Body reminder: ReminderRequest): Call<Reminder>
}
