package com.example.taskmanagernew.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanagernew.App
import com.example.taskmanagernew.R
import com.example.taskmanagernew.data.model.Task
import com.example.taskmanagernew.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {

            if (binding.etTitle2.text.toString().isNotEmpty() || binding.etDesc2.text.toString()
                    .isNotEmpty()
            ) {
                saveTask()
            } else {
                binding.etTitle2.error = getString(R.string.error_title)
                binding.etDesc2.error = getString(R.string.error_title)

            }

        }
    }

    private fun saveTask() {
        val data = Task(
            title = binding.etTitle2.text.toString(),
            desc = binding.etDesc2.text.toString()

        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()

    }
}
