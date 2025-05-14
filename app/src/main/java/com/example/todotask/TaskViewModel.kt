package com.example.todotask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel : ViewModel() {

	private val api = ApiClient.retrofit.create(ApiService::class.java)
	private val repository = TaskRepository(api)

	private val _tasks = MutableLiveData<List<Task>>()
	val tasks: LiveData<List<Task>> = _tasks

	fun loadTasks(userId: Int) {
    	repository.getTasksByUser(userId).enqueue(object : Callback<List<Task>> {
        	override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
            	if (response.isSuccessful) {
                	_tasks.postValue(response.body() ?: emptyList())
            	}
        	}

        	override fun onFailure(call: Call<List<Task>>, t: Throwable) {
            	_tasks.postValue(emptyList()) // Optional: handle error better
        	}
    	})
	}

	fun refreshAllTasks() {
    	repository.getAllTasks().enqueue(object : Callback<List<Task>> {
        	override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
            	if (response.isSuccessful) {
                	_tasks.postValue(response.body() ?: emptyList())
            	}
        	}

        	override fun onFailure(call: Call<List<Task>>, t: Throwable) {
            	_tasks.postValue(emptyList())
        	}
    	})
	}
}


