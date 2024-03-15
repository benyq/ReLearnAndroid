package com.benyq.relearnandroid.feature.record_stack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benyq.relearnandroid.R

class RecordStackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_record_stack)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btn1).setOnClickListener {
            val intent = Intent(this, Activity_A::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            val intent = Intent(this, Activity_B::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
        Log.d("RecordStackActivity", "RecordStackActivity onCreate: $this, $taskId")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("RecordStackActivity", "RecordStackActivity onDestroy: $this, $taskId")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("RecordStackActivity", "onActivityResult: $requestCode")
    }
}