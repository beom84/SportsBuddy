package com.example.sportsbuddy.message

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.ItemMessageBinding

class MessageAdapter(private val itemClick: (String) -> (Unit))
    : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private val messageList = mutableListOf<Message>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.onBind(messageList[position])
    }

    override fun getItemCount(): Int = messageList.size

    fun setItems(newItems: List<Message>) {
        messageList.clear()
        messageList.addAll(newItems)
        notifyDataSetChanged()
    }

    class MessageViewHolder(
        private val binding: ItemMessageBinding,
        private val itemClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Message) {
            with(binding) {
                tvTitle.text = item.title
                tvMessageTime.text = item.time
                tvBody.text = item.body
                tvUserName.text = "[${item.userName}]"
                tvUserDetail.text = "${item.userAge} / ${item.userGender}"

                ivThumbnail.setImageResource(R.drawable.test_image)
                ivThumbnail.clipToOutline = true

                root.setOnClickListener {
                    itemClick(item.userName)
                }
            }
        }
    }
}