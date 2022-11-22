package com.example.taskmanagernew.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.taskmanagernew.data.local.Pref
import com.example.taskmanagernew.databinding.FragmentProfileBinding
import com.example.taskmanagernew.ui.task.utils.loadImage


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
   private lateinit var pref: Pref

    private val getContent:ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()){
            imageUri:Uri?->
            binding.profileImage.loadImage(imageUri.toString())

            Glide.with(this).load(imageUri.toString()).into(binding.profileImage)
            pref.saveImage(imageUri.toString())
        }

companion object{
    private const val CONTENT_TYPE="image/*"
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        pref.getImage()?.let { binding.profileImage.loadImage(it) }
        binding.outlinedEditText.setText(pref.getName())
        binding.outlinedEditText.addTextChangedListener {
            pref.savedName(binding.outlinedEditText.text.toString())
        }

        binding.etAge.setText(pref.getAge())
        binding.etAge.addTextChangedListener {
            pref.saveAge(binding.etAge.text.toString())
        }

        binding.profileImage.setOnClickListener {
            getContent.launch(CONTENT_TYPE)
        }
        binding.profileImage.setOnLongClickListener {
            pref.deleteImage()
            binding.profileImage.loadImage(pref.getImage().toString())
            false
        }

        }
    }




