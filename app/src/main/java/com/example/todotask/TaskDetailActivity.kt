package com.example.todotask

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TaskDetailActivity : AppCompatActivity() {
	private val viewModel: TaskViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
    	super.onCreate(savedInstanceState)
    	setContentView(R.layout.activity_task_detail)

    	val taskId = intent.getIntExtra("taskId", -1)
    	val recyclerView = findViewById<RecyclerView>(R.id.subtasksRecycler)

    	viewModel.tasks.observe(this) { tasks ->
        	val task = tasks.find { it.id == taskId }
        	if (task != null) {
            	// In real app fetch subtasks from API
            	val subtasks = listOf<Subtask>() // placeholder
            	recyclerView.adapter = SubtaskAdapter(subtasks)
            	recyclerView.layoutManager = LinearLayoutManager(this)
        	}
    	}
	}
}
