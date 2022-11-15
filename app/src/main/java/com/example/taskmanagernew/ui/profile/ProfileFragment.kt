package com.example.taskmanagernew.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskmanagernew.R
import com.example.taskmanagernew.databinding.FragmentProfileBinding
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var image:Uri





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileImage.setOnClickListener {
            onClick()

        }

    }
   private fun onClick(){
        val intent=Intent()
       intent.action=Intent.ACTION_GET_CONTENT
       intent.type="image/*"
       startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if(data.data !=null)
                image=data.data!!
            binding.profileImage.setImageURI(image)

        }
    }
    }


