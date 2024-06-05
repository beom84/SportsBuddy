package com.example.sportsbuddy.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportsbuddy.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {

    private var _binding : FragmentSampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSampleBinding.inflate(inflater, container, false)
        return binding.root
    }
}