package com.benyq.relearnandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import com.benyq.relearnandroid.animation.AnimationActivity
import com.benyq.relearnandroid.databinding.ActivityMainBinding
import com.benyq.relearnandroid.mvi.test.MVITestActivity
import com.benyq.relearnandroid.widget.CustomViewActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnMvi.setOnClickListener {
            startActivity(Intent(this, MVITestActivity::class.java))
        }
        binding.btnCustomView.setOnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
        }
        binding.btnAnimation.setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }
}
