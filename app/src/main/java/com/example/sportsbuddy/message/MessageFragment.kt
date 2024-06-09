package com.example.sportsbuddy.message

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.FragmentMessageBinding

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
            Message("축구 할 사람", "3분 전", "언제가 좋으세요?", "신민석가모니", 24, "남자", R.drawable.test_image),
            Message("한아름 볼링 칠 사람", "17분 전", "지금 나와", "단단한 두부", 24, "여자", R.drawable.test_image),
            Message("농구할 팀원 구해요~", "54분 전", "저는 평일 저녁 아무때나 가능합니다~~:)", "야호야호야호", 24, "남자", R.drawable.test_image),
            Message("같이 헬스할 메이트 구합니다", "13시간 전", "헬스 같이 하고 싶어요!", "개포동프린세스", 24, "여자", R.drawable.test_image),
            Message("러닝 뛸 사람", "2일 전", "한강에서 러닝 같이 뛰실래ㅇㅕ?", "잠실프린세스", 24, "여자", R.drawable.test_image),
        ))
        adapter.setItems(list)
    }

    private fun setLayoutManager() {
        binding.rvMessage.layoutManager = LinearLayoutManager(requireContext())
        adapter = MessageAdapter {username ->
            startActivity(MessageDetailActivity.getIntent(requireContext(), username))
        }
        binding.rvMessage.adapter = adapter
        adapter.setItems(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}