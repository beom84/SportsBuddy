package com.example.sportsbuddy.match.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.ActivityMatchDetailBinding
import com.example.sportsbuddy.match.Match

class MatchDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchDetailBinding
    private var match: Match? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.window?.apply {
            this.statusBarColor = getColor(R.color.grey_background)
        }

        match = intent.getSerializableExtra("match") as Match
        Log.d("buddy-detail", "match: $match")

        initView()
    }

    private fun initView() {
        with(binding) {
            if (match != null) {
                tvMatchTitle.text = match!!.title
                tvUserName.text = "[${match!!.userName}]"
                tvUserDetail.text = "${match!!.userAge} / ${match!!.userGender}"
                tvTypeInput.text = match!!.type
                tvLevelInput.text = match!!.userLevel
                tvAreaInput.text = match!!.area
                tvTimeInput.text = match!!.time
                tvRecruitInput.text = "${match!!.curCount}명 / ${match!!.maxCount}명"
                tvContentInput.text = match!!.content
                ivThumbnail.setImageResource(match!!.thumbnail)
                ivThumbnail.clipToOutline = true
            } else {
                ivThumbnail.setImageResource(R.color.white)
                ivThumbnail.clipToOutline = true
            }
        }
    }

    companion object {
        fun getIntent(context: Context, match: Match) = Intent(context, MatchDetailActivity::class.java).apply{
            putExtra("match", match)
        }
    }
}