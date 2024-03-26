package com.benyq.relearnandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benyq.relearnandroid.base.extensions.dp
import com.benyq.relearnandroid.feature.animation.AnimationActivity
import com.benyq.relearnandroid.databinding.ActivityMainBinding
import com.benyq.relearnandroid.feature.FunctionAdapter
import com.benyq.relearnandroid.feature.FunctionItem
import com.benyq.relearnandroid.feature.GridItemDecoration
import com.benyq.relearnandroid.feature.mvi.test.MVITestActivity
import com.benyq.relearnandroid.feature.other_app_func.OtherAppFunctionActivity
import com.benyq.relearnandroid.feature.record_stack.RecordStackActivity
import com.benyq.relearnandroid.widget.CustomViewActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.layoutManager = GridLayoutManager(this, 4)
        binding.recycler.adapter = FunctionAdapter(loadData()) {
            startActivity(Intent(this, it.clazz))
        }
        binding.recycler.addItemDecoration(GridItemDecoration(10.dp, 10.dp))
    }

    private fun loadData() = listOf(
        FunctionItem("动画", AnimationActivity::class.java),
        FunctionItem("MVI", MVITestActivity::class.java),
        FunctionItem("记录栈", RecordStackActivity::class.java),
        FunctionItem("自定义View", CustomViewActivity::class.java),
        FunctionItem("其它App效果", OtherAppFunctionActivity::class.java),
    )
}
