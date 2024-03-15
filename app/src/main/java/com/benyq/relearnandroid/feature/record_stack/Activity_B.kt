package com.benyq.relearnandroid.feature.record_stack

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benyq.relearnandroid.R

class Activity_B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = TextView(this)
        textView.text = "Activity B: $this"
        textView.textSize = 30f
        textView.setTextColor(Color.BLACK)
        findViewById<FrameLayout>(R.id.main).addView(textView, FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
            gravity = Gravity.CENTER
        })

        textView.setOnClickListener {
            val intent = Intent(this, RecordStackActivity::class.java)
            startActivity(intent)
        }

        Log.d("Activity_B", "Activity_B onCreate: $this, $taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("Activity_B", "Activity_B onNewIntent: $this, $taskId")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity_B", "Activity_B onDestroy: $this, $taskId")
    }
}