package com.benyq.relearnandroid.ipc.server

import android.app.Application
import android.util.Log

class ServerApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("ServerApp", "onCreate: server")
    }
}