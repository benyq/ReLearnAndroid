package com.benyq.relearnandroid.ipc.client

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.benyq.relearnandroid.ipc.aidl.Game
import com.benyq.relearnandroid.ipc.aidl.IGameManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<TextView>(R.id.tv).setOnClickListener {
            connectService()
//            startActivity(Intent("android.intent.action.benyq"))
        }
    }

    private val serviceConnection = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("benyq", "onServiceConnected: $name")
            val iGameManager = IGameManager.Stub.asInterface(service)
            iGameManager.addGame(Game().apply {
                gameName = "大侠立志传"
                gameDescribe = "武侠游戏"
            })
            iGameManager.gameList.forEach {
                Log.d("benyq", "games: ${it.gameName} -- ${it.gameDescribe}")
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("benyq", "onServiceDisconnected： $name")
        }

    }

    private fun connectService() {
        val intent = Intent("com.benyq.relearnandroid.ipc.AIDLService")
        intent.setPackage("com.benyq.relearnandroid.ipc.server")
//        intent.setComponent(ComponentName("com.benyq.relearnandroid.ipc.server", "com.benyq.relearnandroid.ipc.server.AIDLService"))
        val res = bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        Log.d("benyq", "bindService: $res")
    }
}