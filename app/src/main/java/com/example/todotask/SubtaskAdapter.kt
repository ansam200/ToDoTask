package com.example.todotask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class SubtaskAdapter(
	private val subtasks: List<Subtask>
) : RecyclerView.Adapter<SubtaskAdapter.SubtaskViewHolder>() {

	inner class SubtaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    	val checkbox: CheckBox = view.findViewById(R.id.checkboxSubtask)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtaskViewHolder {
    	val view = LayoutInflater.from(parent.context)
        	.inflate(R.layout.item_subtask, parent, false)
    	return SubtaskViewHolder(view)
	}

	override fun onBindViewHolder(holder: SubtaskViewHolder, position: Int) {
    	val subtask = subtasks[position]
    	holder.checkbox.text = subtask.title
    	holder.checkbox.isChecked = subtask.isCompleted

    	holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
        	subtask.isCompleted = isChecked
    	}
	}

	override fun getItemCount(): Int = subtasks.size
}
