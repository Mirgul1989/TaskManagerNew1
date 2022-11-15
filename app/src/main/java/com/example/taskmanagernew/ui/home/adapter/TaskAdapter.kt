package com.example.taskmanagernew.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanagernew.databinding.ItemTaskBinding
import com.example.taskmanagernew.model.Task

class TaskAdapter(): Adapter<TaskAdapter.TaskViewHolder>() {
    private val task: ArrayList<Task> = arrayListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(task.get(position))

    }

    override fun getItemCount(): Int {
       return task.size
    }
    inner class TaskViewHolder(private val binding: ItemTaskBinding) :ViewHolder(binding.root){
        fun bind(task: Task){

        }
    }
}