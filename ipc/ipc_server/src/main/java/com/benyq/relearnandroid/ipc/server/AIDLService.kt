package com.benyq.relearnandroid.ipc.server

import android.app.Service
import android.content.Intent
import android.util.Log
import com.benyq.relearnandroid.ipc.aidl.Game
import com.benyq.relearnandroid.ipc.aidl.IGameManager

class AIDLService : Service() {

    private val games = mutableListOf<Game>()

    private val binder = object : IGameManager.Stub() {
        override fun getGameList(): MutableList<Game> {
            return games
        }

        override fun addGame(game: Game) {
            games.add(game)
        }

    }
    override fun onBind(intent: Intent) = binder

    override fun onCreate() {
        super.onCreate()
        Log.d("benyq", "onCreate: AIDLService")
        games.add(Game().apply {
            gameName = "lol"
            gameDescribe = "兄弟lol, best lol"
        })
    }
}