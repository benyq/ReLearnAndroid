package com.benyq.relearnandroid.ipc.aidl;
import com.benyq.relearnandroid.ipc.aidl.Game;
interface IGameManager {
    List<Game> getGameList();
    void addGame(in Game game);
}