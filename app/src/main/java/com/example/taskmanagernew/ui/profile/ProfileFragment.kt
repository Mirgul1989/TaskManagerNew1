package com.example.taskmanagernew.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.taskmanagernew.databinding.FragmentProfileBinding

@Suppress("DEPRECATION")
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    //private lateinit var image:Uri
    private val getContent:ActivityResultLauncher<String> =
        registerForActivityResult(ActivityResultContracts.GetContent()){
            imageUri:Uri?-> binding.profileImage.setImageURI(imageUri)
        }



companion object{
    private const val CONTEN_TYPE="image/*"
}
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
           // onClick()
            getContent.launch(CONTEN_TYPE)

        }

    }
  // private fun onClick(){
    //    val intent=Intent()
      // intent.action=Intent.ACTION_GET_CONTENT
       //intent.type="image/*"
       //startActivityForResult(intent,1)
    //}

    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      //  super.onActivityResult(requestCode, resultCode, data)
        //if (data != null) {
          //  if(data.data !=null)
            //    image=data.data!!
            //binding.profileImage.setImageURI(image)

        //}
    }


