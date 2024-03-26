package com.benyq.relearnandroid.feature.other_app_func.flip_book_cover

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benyq.relearnandroid.R


class BookshelfActivity : AppCompatActivity(), View.OnClickListener {

    private var bookshlefBook: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bookshelf)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        bookshlefBook = findViewById(R.id.iv_bookshlef_book)
        bookshlefBook?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (BookConfig.isRunning) return
        BookConfig.start()
        val bitmap = (bookshlefBook!!.background as BitmapDrawable).bitmap
        BookConfig.coverBitmap = bitmap
        BookConfig.left = bookshlefBook!!.left.toFloat()
        BookConfig.top = bookshlefBook!!.top.toFloat()
        BookConfig.width = bookshlefBook!!.width.toFloat()
        BookConfig.height = bookshlefBook!!.height.toFloat()

        val intent = Intent(this@BookshelfActivity, ReaderActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

}