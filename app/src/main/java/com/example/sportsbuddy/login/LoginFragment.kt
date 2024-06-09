package com.example.sportsbuddy.login


import android.os.Bundle
import androidx.fragment.app.Fragment

import com.example.sportsbuddy.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.cvLogin .setContent {
            LoginScreen()
        }

    }


}

