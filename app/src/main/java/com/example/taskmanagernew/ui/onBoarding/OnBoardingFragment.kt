package com.example.taskmanagernew.ui.onBoarding


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanagernew.data.local.Pref
import com.example.taskmanagernew.databinding.FragmentOnBoardingBinding
import com.example.taskmanagernew.ui.onBoarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireActivity())
        val adapter = OnBoardingAdapter {
            pref.savedShowBoarding(true)
            findNavController().navigateUp()
        }
        binding.viewPager.adapter = adapter


    }


}

