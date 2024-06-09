package com.example.sportsbuddy.message

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.ActivityMessageDetailBinding

class MessageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageDetailBinding

    private lateinit var adapter: ChatAdapter
    private val list = mutableListOf<Chat>()
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMessageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.window?.apply {
            this.statusBarColor = getColor(R.color.grey_background)
        }

        username = intent.getStringExtra("user_name") ?: "Unknown"
        setLayoutManager()
        initChat()
        initSendListener()
    }

    private fun initChat() {
        when (username) {
            "신민석가모니" -> {
                list.addAll(
                    listOf(
                        Chat(username, "안녕하세요. 같이 하고 싶어요.", 0),
                        Chat(username, "언제가 좋으세요?", 1),
                    )
                )
            }

            "단단한 두부" -> {
                list.addAll(
                    listOf(
                        Chat(username, "볼링 고고?", 1),
                        Chat(username, "언제?", 0),
                        Chat(username, "지금 나와", 1)
                    )
                )
            }

            "야호야호야호" -> {
                list.addAll(
                    listOf(
                        Chat(username, "농구 같이 하고 싶습니다!", 1),
                        Chat(username, "혹시 어디서 하고 싶으세요?", 1),
                        Chat(username, "양재천이요!", 0),
                        Chat(username, "좋습니다! 언제 가능하세요?", 1),
                        Chat(username, "저는 평일 저녁 아무때나 가능합니다~~:)", 0),
                        Chat(username, "야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호야호", 0)
                    )
                )
            }

            "개포동프린세스" -> {
                list.addAll(
                    listOf(
                        Chat(username, "헬스 같이 하고 싶어요!", 0),
                    )
                )
            }

            "잠실프린세스" -> {
                list.addAll(
                    listOf(
                        Chat(username, "한강에서 러닝 같이 뛰실래ㅇㅕ?", 0),
                        Chat(username, "네 조아여", 1),
                    )
                )
            }
        }
        adapter.setData(list)
    }

    private fun setLayoutManager() {
        binding.rvMessage.layoutManager = LinearLayoutManager(this)
        adapter = ChatAdapter()
        binding.rvMessage.adapter = adapter
        adapter.setData(list)
    }

    private fun initSendListener() {
        binding.chatSendButton.setOnClickListener {
            if (binding.chatMessage.text.isNotEmpty()) {
                list.add(Chat(username, binding.chatMessage.text.toString(), 1))
                binding.chatMessage.text.clear()
                adapter.setData(list)
            }
        }
    }

    companion object {
        fun getIntent(context: Context, userName: String) =
            Intent(context, MessageDetailActivity::class.java).apply {
                putExtra("user_name", userName)
            }
    }
}