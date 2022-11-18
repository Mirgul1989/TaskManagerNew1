package com.example.taskmanagernew.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanagernew.R
import com.example.taskmanagernew.data.model.Task
import com.example.taskmanagernew.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentTaskBinding.inflate(inflater,container,false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {

            if (binding.etTitle2.text.toString().isNotEmpty() || binding.etDesc2.text.toString().isNotEmpty()) {
                saveTask()
            } else {
                binding.etTitle2.error = getString(R.string.error_title)
                binding.etDesc2.error = getString(R.string.error_title)

            }

        }
    }
private fun saveTask(){
    val data= Task(
        binding.etTitle2.text.toString(),
        binding.etDesc2.text.toString()

    )
    setFragmentResult(
        "KeyHome", bundleOf("task" to data))
    findNavController().navigateUp()

}
}
