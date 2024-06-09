package com.example.sportsbuddy.message

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsbuddy.databinding.BotChatMessageBinding
import com.example.sportsbuddy.databinding.UserChatMessageBinding

class ChatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<Chat>()
    interface OnItemClickListener {
        fun OnChatBotClick(message: String)
    }

    var itemClickListener: OnItemClickListener?= null

    inner class BotViewHolder (val botbinding: BotChatMessageBinding): RecyclerView.ViewHolder(botbinding.root){
        private  val chatText = botbinding.tvMessage
        fun bind(item: Chat){
            botbinding.tvBotName.text = item.useName
            chatText.text = item.message
        }

//        init {
//            botbinding.txtMessage.setOnClickListener {
//                itemClickListener?.OnChatBotClick(items[adapterPosition].message)
//            }
//        }
    }

    inner class UserViewHolder(val userbinding: UserChatMessageBinding): RecyclerView.ViewHolder(userbinding.root){
        private  val chatText = userbinding.tvMessage
        fun bind(item: Chat){
            chatText.text = item.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ChatViewType.BOT){
            return BotViewHolder(
                BotChatMessageBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false)
            )
        }
        return UserViewHolder(
            UserChatMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(items[position].chatType) {
            ChatViewType.BOT -> {
                (holder as BotViewHolder).bind(items[position])
            }
            ChatViewType.USER -> {
                (holder as UserViewHolder).bind(items[position])
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return items[position].chatType
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Chat>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}