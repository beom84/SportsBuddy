package com.example.sportsbuddy.myprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sportsbuddy.databinding.FragmentMyprofileBinding

class MyProfileFragment :  Fragment()  {

    private lateinit var binding: FragmentMyprofileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentMyprofileBinding.inflate(layoutInflater)
        binding.cvMyprofile .setContent {
            MyProfileScreen()
        }
    }

}

