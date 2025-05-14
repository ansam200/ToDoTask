package com.example.todotask

import retrofit2.Call

class TaskRepository(private val api: ApiService) {

	fun getAllTasks(): Call<List<Task>> = api.getTasks()

	fun getTasksByUser(userId: Int): Call<List<Task>> = api.getTasksByUser(userId)

	fun createTask(taskRequest: TaskRequest): Call<Task> = api.createTask(taskRequest)

	fun updateTask(id: Int, taskRequest: TaskRequest): Call<Task> = api.updateTask(id, taskRequest)

	fun deleteTask(id: Int): Call<Void> = api.deleteTask(id)
}
