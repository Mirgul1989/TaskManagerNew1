package com.example.taskmanagernew.ui.home
import com.example.taskmanagernew.ui.home.adapter.TaskAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.taskmanagernew.App
import com.example.taskmanagernew.R
import com.example.taskmanagernew.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter= TaskAdapter(context = requireContext(), activity = FragmentActivity())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter=adapter
        var data= App.db.taskDao().getAllTask()  //получение данных
        adapter.addTask(data)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
       // binding.fab.setOnLongClickListener {
           // dialog()
           // false
       // }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  //  private fun dialog() {
    //    val alertDialog= AlertDialog.Builder(this.requireContext())
      //  alertDialog.setTitle("Delete?")

      // alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which -> })


        //alertDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> })
//alertDialog.show()
    }


