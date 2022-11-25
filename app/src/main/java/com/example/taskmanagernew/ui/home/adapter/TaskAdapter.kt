

import android.annotation.SuppressLint

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanagernew.App
import com.example.taskmanagernew.data.model.Task
import com.example.taskmanagernew.databinding.ItemTaskBinding

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
    }


    fun addTasks(task: Task) {
        tasks.add(0, task)
        notifyItemChanged(0)
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
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
            itemView.setOnLongClickListener {
                dialog(task)
                return@setOnLongClickListener false
            }

        }

        @SuppressLint("NotifyDataSetChanged")
        private fun dialog(task: Task) {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Delete?")

            alertDialog.setPositiveButton("YES", DialogInterface.OnClickListener { _, _ ->
               App.db.taskDao().delete(task)
                activity?.recreate()
                notifyDataSetChanged();
                DialogInterface.OnDismissListener {  }
            })
            alertDialog.setNegativeButton(
                "NO",
                DialogInterface.OnClickListener { _, _ ->

                })
            alertDialog.show()
        }




    }


}