package com.industrialmaster.sachin_app1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class backMusic extends Service {

    MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player =MediaPlayer.create(this,R.raw.backmusic);
        player.setLooping(true);
        player.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }
}
