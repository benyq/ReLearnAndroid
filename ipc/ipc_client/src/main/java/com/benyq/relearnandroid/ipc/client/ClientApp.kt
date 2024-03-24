package com.benyq.relearnandroid.ipc.client

import android.app.Application
import android.util.Log

class ClientApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("ClientApp", "onCreate: client")
    }
}