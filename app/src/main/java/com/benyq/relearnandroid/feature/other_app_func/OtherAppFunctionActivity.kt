package com.benyq.relearnandroid.feature.other_app_func

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.benyq.relearnandroid.R
import com.benyq.relearnandroid.base.extensions.dp
import com.benyq.relearnandroid.databinding.ActivityMainBinding
import com.benyq.relearnandroid.databinding.ActivityOtherAppFunctionBinding
import com.benyq.relearnandroid.feature.FunctionAdapter
import com.benyq.relearnandroid.feature.FunctionItem
import com.benyq.relearnandroid.feature.GridItemDecoration
import com.benyq.relearnandroid.feature.other_app_func.flip_book_cover.BookshelfActivity

class OtherAppFunctionActivity : AppCompatActivity() {

    private val binding by lazy { ActivityOtherAppFunctionBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recycler.layoutManager = GridLayoutManager(this, 4)
        binding.recycler.adapter = FunctionAdapter(loadData()) {
            startActivity(Intent(this, it.clazz))
        }
        binding.recycler.addItemDecoration(GridItemDecoration(10.dp, 10.dp))
    }

    private fun loadData() = listOf(
        FunctionItem("书本打开效果", BookshelfActivity::class.java)
    )
}