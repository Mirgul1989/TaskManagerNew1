package com.example.taskmanagernew.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanagernew.App
import com.example.taskmanagernew.R
import com.example.taskmanagernew.data.model.Task
import com.example.taskmanagernew.databinding.ItemTaskBinding

@Suppress("DEPRECATION")
class TaskAdapter(
    private val tasks: ArrayList<Task> = arrayListOf(),
    val context: Context,
    val activity: FragmentActivity?

) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])

       // if (position % 2==0)


    }

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(newTask: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(newTask)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return tasks.size
    }


    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            if ((position % 1) == 0) {
                binding.tvTitle.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
                 }
            if (position % 1 == 0) {
                binding.tvDesc.setBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.white
                    )
                )
            }




                binding.tvTitle.text = task.title
                binding.tvDesc.text = task.desc
                itemView.setOnLongClickListener {
                    dialog(task)
                    return@setOnLongClickListener true
                }

            }

            private fun dialog(task: Task) {
                val alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("Delete?")

                alertDialog.setPositiveButton("YES") { dialogInterface, _ ->
                    App.db.taskDao().delete(task)
                    taskDelete(task)
                    dialogInterface.dismiss()
                    // activity?.recreate()
                    // notifyDataSetChanged();
                    //DialogInterface.OnDismissListener { }
                }
                alertDialog.setNegativeButton(
                    "NO"
                ) { dialogInterface, _ ->
                    dialogInterface.cancel()
                }

                alertDialog.show()


            }

            private fun taskDelete(task: Task) {
                tasks.remove(task)
                notifyDataSetChanged()

            }

        }}