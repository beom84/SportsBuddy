package com.example.sportsbuddy.message

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.FragmentMessageBinding
import com.example.sportsbuddy.match.Match
import com.example.sportsbuddy.match.detail.MatchDetailActivity
import com.example.sportsbuddy.match.list.MatchListAdapter

class MessageFragment : Fragment() {

    private var _binding : FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MessageAdapter
    private val list = mutableListOf<Message>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayoutManager()
        initMessageItems()
    }

    private fun initMessageItems() {
        list.addAll(listOf(
            Message("축구 할 사람", "3분 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("한아름 볼링 칠 사람", "17분 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("축구 할 사람", "54분 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("한아름 볼링 칠 사람", "3시간 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("축구 할 사람", "5시간 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("한아름 볼링 칠 사람", "1일 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("축구 할 사람", "3일 전", "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", "신민석가모니", 24, "남자", R.drawable.test_image),
        ))
        adapter.setItems(list)
    }

    private fun setLayoutManager() {
        binding.rvMessage.layoutManager = LinearLayoutManager(requireContext())
        adapter = MessageAdapter {
            activity?.startActivity(MessageDetailActivity.getIntent(requireContext(), it))
        }
        binding.rvMessage.adapter = adapter
        adapter.setItems(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}