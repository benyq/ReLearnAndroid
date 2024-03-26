package com.benyq.relearnandroid.feature.other_app_func.flip_book_cover

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benyq.relearnandroid.R

class ReaderActivity : AppCompatActivity() {

    private lateinit var openBookview: OpenBookView
    private lateinit var flContent: FrameLayout

    private var flWidth = 0
    private var flHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reader)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fl_content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            Log.d("benyq", "onCreate: $v")
            insets
        }
        openBookview = findViewById(R.id.openbookview)
        flContent = findViewById(R.id.fl_content)

        findViewById<TextView>(R.id.tv_content).setOnClickListener {
            Toast.makeText(this, "点击内容", Toast.LENGTH_SHORT).show()
        }
        flContent.pivotX = 0f
        flContent.pivotY = 0f

        openBookview.setContentChangeListener { x, y, scaleX, scaleY ->
            val w = (flWidth - BookConfig.width) * scaleX + BookConfig.width
            val h = (flHeight - BookConfig.height) * scaleX + BookConfig.height
            flContent.translationX = x
            flContent.translationY = y
            flContent.scaleX = w / flWidth
            flContent.scaleY = h / flHeight
        }
        openBookview.viewTreeObserver.addOnGlobalLayoutListener {
            flWidth = flContent.width
            flHeight = flContent.height
            Log.d("benyq", "onCreate: addOnGlobalLayoutListener")
            openBookview.openAnimation(BookConfig.coverBitmap!!,
                BookConfig.left,
                BookConfig.top,
                BookConfig.width,
                BookConfig.height,
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        BookConfig.stop()
                    }
                })
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (BookConfig.isRunning) return
                openBookview.closeAnimation(BookConfig.coverBitmap,
                    BookConfig.width,
                    BookConfig.height,
                    object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            finish()
                            overridePendingTransition(0, 0)
                            BookConfig.release()
                        }
                    })
            }
        })
    }
}