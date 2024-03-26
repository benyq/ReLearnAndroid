package com.benyq.relearnandroid.feature.other_app_func.flip_book_cover

import android.graphics.Bitmap

object BookConfig {

    var isRunning: Boolean = false
    var coverBitmap: Bitmap? = null

    var left: Float = 0f
    var top: Float = 0f

    var width: Float = 0f
    var height: Float = 0f

    fun start() {
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }

    fun release() {
        coverBitmap = null
    }
}