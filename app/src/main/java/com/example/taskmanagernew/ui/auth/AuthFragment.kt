package com.example.taskmanagernew.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanagernew.databinding.FragmentAuthBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class AuthFragment : Fragment() {
    private lateinit var binding: FragmentAuthBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {
            requestSMS()

        }


        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                signInWithPhoneAuthCredential(credential)
            }
            private fun phoneCode(code:String){
                val credential = PhoneAuthProvider.getCredential(code,binding.etKod.text.toString())
                signInWithPhoneAuthCredential(credential)
            }

            private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
                Firebase.auth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigateUp()
                    } else {
                        Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
                    }

                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {

            }
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(verificationId, token)
                binding.btnOk.setOnClickListener {
                    phoneCode(verificationId)


                }
            }
        }
    }


    private fun requestSMS() {
        val number = binding.etId.text.toString()
        if (number.isEmpty()) {
            binding.etId.error = "Введите номер"
        }
        val options = PhoneAuthOptions.newBuilder(Firebase.auth)
            .setPhoneNumber(number)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)


    }

    override fun onStart() {
        super.onStart()
        if (Firebase.auth.currentUser != null) {
            findNavController().navigateUp()
        }
    }
}