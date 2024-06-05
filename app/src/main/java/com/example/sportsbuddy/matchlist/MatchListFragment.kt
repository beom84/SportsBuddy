package com.example.sportsbuddy.matchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.FragmentMatchListBinding

class MatchListFragment : Fragment() {
    private var _binding : FragmentMatchListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : MatchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayoutManager()
    }

    private fun setLayoutManager() {
        adapter = MatchListAdapter {

        }
        binding.rvMatch.adapter = adapter
        adapter.setItems(listOf(
            Match("축구 할 사람", 14, 22, "서울시 광진구", "최민규카츠", 22, "남자"),
            Match("농구 할 사람", 5, 10, "서울시 광진구", "최민규카츠", 22," 남자"),
            Match("볼링 칠 사람", 6, 6, "서울시 광진구", "최민규카츠", 22, "남자"),
            Match("축구 할 사람", 4, 22, "서울시 광진구", "최민규카츠", 22, "남자")
        ))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}