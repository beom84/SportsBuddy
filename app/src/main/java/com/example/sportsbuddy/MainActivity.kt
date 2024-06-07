package com.example.sportsbuddy

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.sportsbuddy.databinding.ActivityMainBinding
import com.example.sportsbuddy.match.list.MatchListFragment
import com.example.sportsbuddy.sample.SampleFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            SportsBuddyTheme {
//                MainScreen()
//            }
//        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBnvItemSelectedListener()

        this.window?.apply {
            this.statusBarColor = getColor(R.color.grey_background)
        }
    }

    private fun initBnvItemSelectedListener() {
        supportFragmentManager.findFragmentById(R.id.fcv_main) ?: navigateTo<MatchListFragment>()
        binding.bnvMain.selectedItemId = R.id.menu_search
        binding.bnvMain.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menu_message -> {
                    navigateTo<SampleFragment>()
                }
                R.id.menu_search -> {
                    navigateTo<MatchListFragment>()
                }
                R.id.menu_profile -> {
//                    navigateTo<~Fragment>()
                }
            }
            true
        }
    }

    private inline fun <reified T : Fragment> navigateTo() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_main, T::class.java.canonicalName)
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}

