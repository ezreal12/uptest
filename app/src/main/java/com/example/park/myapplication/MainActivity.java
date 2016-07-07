package com.example.park.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.WindowManager;


import com.example.park.myapplication.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends Activity {
    private IjkVideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics=getMetrics();

        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVideoView.play("http://us.live.npvr.net/sj/mbc/live.stream/playlist.m3u8");

    }
    private DisplayMetrics getMetrics(){
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==4){
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onKeyDown(keyCode, event);
    }
}
