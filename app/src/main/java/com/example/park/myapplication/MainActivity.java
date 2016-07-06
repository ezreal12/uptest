package com.example.park.myapplication;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.park.myapplication.application.Settings;
import com.example.park.myapplication.widget.media.AndroidMediaController;
import com.example.park.myapplication.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity {
    private IjkVideoView mVideoView;
    private Settings mSettings;
    private AndroidMediaController mMediaController;
    private TextView mToastTextView;
    private TableLayout mHudView;
    private DrawerLayout mDrawerLayout;
    private ViewGroup mRightDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = new Settings(this);
        /*if (!TextUtils.isEmpty("http://121.135.198.97/ontv/91777/T91777_121_160629.ts")) {
            new RecentMediaStorage(this).saveUrlAsync(mVideoPath);
        }*/


        ActionBar actionBar = getSupportActionBar();
        mMediaController = new AndroidMediaController(this, false);
        mMediaController.setSupportActionBar(actionBar);

        mToastTextView = (TextView) findViewById(R.id.toast_text_view);
        mHudView = (TableLayout) findViewById(R.id.hud_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mRightDrawer = (ViewGroup) findViewById(R.id.right_drawer);

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        mVideoView = (IjkVideoView) findViewById(R.id.video_view);
        mVideoView.setMediaController(mMediaController);
        mVideoView.setHudView(mHudView);

        mVideoView.setVideoPath("http://121.135.198.97/ontv/91777/T91777_121_160629.ts");
        mVideoView.start();
    }
}
