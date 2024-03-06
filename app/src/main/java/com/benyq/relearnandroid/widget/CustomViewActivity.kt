package com.benyq.relearnandroid.widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benyq.relearnandroid.R
import com.benyq.relearnandroid.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCustomViewBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}