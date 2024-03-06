package com.benyq.relearnandroid.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.collection.arrayMapOf
import androidx.core.view.updateLayoutParams
import com.benyq.relearnandroid.base.extensions.dp
import com.benyq.relearnandroid.base.extensions.ifTrue
import com.benyq.relearnandroid.databinding.ActivityAnimationBinding
import java.nio.channels.FileChannel

class AnimationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAnimationBinding.inflate(layoutInflater) }
    private var isExpanded = true
    private var anim: ValueAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.container.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }
        binding.btnChange.setOnClickListener {
            animation1()
        }

        binding.container.viewTreeObserver.addOnGlobalLayoutListener {
            Log.d("benyq", "onGlobalLayout: ")
        }
    }

    private fun animation1() {
        val endSize = if (isExpanded) 50f.dp else 100f.dp
        val currentSize = binding.container.width.toFloat()
        anim?.isRunning?.ifTrue {
            anim?.end()
        }
        anim = ObjectAnimator.ofFloat(currentSize, endSize).also {
            it.duration = 500
            it.addUpdateListener {
                binding.container.updateLayoutParams {
                    width = (it.animatedValue as Float).toInt()
                    height = (it.animatedValue as Float).toInt()
                }
            }
            it.start()
        }
        isExpanded = !isExpanded
    }

    private fun animation2() {
        val endSize = if (isExpanded) 40f else 1f
        binding.container.animate().scaleX(endSize).scaleY(endSize).setDuration(500).start()
        isExpanded = !isExpanded
    }

    private fun viewAnimation(view: View) {
        binding.container.animate().cancel()
    }

    private fun animation3() {
        val tAnim = TranslateAnimation(0f, 0f, 0f, 500f)
        tAnim.fillAfter = true
        binding.container.startAnimation(tAnim)
    }
}