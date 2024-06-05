package com.example.sportsbuddy.match.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.ItemMatchBinding
import com.example.sportsbuddy.match.Match

class MatchListAdapter(private val itemClick: (Match) -> (Unit))
    : RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder>() {

    private val matchList = mutableListOf<Match>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchListViewHolder {
        val binding = ItemMatchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MatchListViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: MatchListViewHolder, position: Int) {
        holder.onBind(matchList[position])
    }

    override fun getItemCount(): Int = matchList.size

    fun setItems(newItems: List<Match>) {
        matchList.clear()
        matchList.addAll(newItems)
        notifyDataSetChanged()
    }

    class MatchListViewHolder(
        private val binding: ItemMatchBinding,
        private val itemClick: (Match) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Match) {
            with(binding) {
                tvTitle.text = item.title
                tvRecruitCount.text = "${item.curCount}명 / ${item.maxCount}명"
                tvAreaDetail.text = item.area
                tvUserName.text = "[${item.userName}]"
                tvUserDetail.text = "${item.userAge} / ${item.userGender}"

                ivThumbnail.setImageResource(R.drawable.test_image)
                ivThumbnail.clipToOutline = true

                root.setOnClickListener {
                    itemClick(item)
                }
            }
        }
    }
}