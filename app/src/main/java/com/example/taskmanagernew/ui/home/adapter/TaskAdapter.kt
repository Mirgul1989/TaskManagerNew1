package com.example.taskmanagernew.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanagernew.databinding.ItemTaskBinding
import com.example.taskmanagernew.model.Task

class TaskAdapter(): Adapter<TaskAdapter.TaskViewHolder>() {
    private val tasks: ArrayList<Task> = arrayListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])

    }
    fun addTask(task: Task){
        tasks.add(0,task)
        notifyItemChanged(0)

    }

    override fun getItemCount(): Int {
       return tasks.size
    }
    inner class TaskViewHolder(private val binding: ItemTaskBinding) :ViewHolder(binding.root){
        fun bind(task: Task){
            binding.tvTitle.text=task.title
            binding.tvDesc.text=task.desc

        }
    }
}