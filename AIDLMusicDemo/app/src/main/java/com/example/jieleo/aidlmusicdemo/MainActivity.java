package com.example.jieleo.aidlmusicdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private MyAIDL mMyAIDL;
    private MusicBean mMusicBean;
    private SeekBar mSeekBar;
    private boolean isAlive = true;
    private TextView nowTimeTv, durationTimeTv;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMyAIDL = MyAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        Intent mIntent = new Intent(this, MusicService.class);
        startService(mIntent);
        bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
        nowTimeTv = (TextView) findViewById(R.id.now_time_tv);
        durationTimeTv = (TextView) findViewById(R.id.duration_tv);
        findViewById(R.id.play_btn).setOnClickListener(this);
        findViewById(R.id.next_btn).setOnClickListener(this);
        findViewById(R.id.last_btn).setOnClickListener(this);

        reflashSeekBar();
        mSeekBar.setOnSeekBarChangeListener(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        isAlive = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_btn:
                if (mMyAIDL != null) {
                    try {
                        if (mMyAIDL.isPlaying()) {
                            mMyAIDL.pauseMusic();
                        } else {
                            if (mMyAIDL.isFirst()) {
                                mMyAIDL.playMusic();
                            } else {
                                mMyAIDL.countinuePlay();
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.last_btn:
                if (mMyAIDL != null) {
                    try {
                        mMyAIDL.playLast();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.next_btn:
                if (mMyAIDL != null) {
                    try {
                        mMyAIDL.playNext();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }


    public void reflashSeekBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isAlive) {
                    try {
                        if (mMyAIDL != null && mMyAIDL.isPlaying()) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        mSeekBar.setMax(mMyAIDL.getDuringTime());
                                        mSeekBar.setProgress(mMyAIDL.getCurrentProgress());
                                        nowTimeTv.setText(getDateFormat(mMyAIDL.getCurrentProgress()));
                                        durationTimeTv.setText(getDateFormat(mMyAIDL.getDuringTime()));
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        try {
            mMyAIDL.setMediaProgress(seekBar.getProgress());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getDateFormat(int object) {
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        String time = dateFormat.format(new Date(object));

        return time;
    }


}
