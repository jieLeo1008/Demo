package com.lanou.dllo.mediaplayer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private SeekBar seekBar;

    private NotificationManager mNotificationManager;
    private MediaPlayService.MyBind myBind;


    //绑定服务用的intent
    private Intent intent;
    //绑定服务用的ServiceConnection对象
    private ServiceConnection serviceConnection;

    //声明广播接收器
    private SongReceiver songReceiver;

    private TextView singerNameTv,songNameTv;
    private ImageView headIv;

    //声明当前歌曲播放的位置
    private int position;

    private ArrayList<SongsBean>  songsBeen;

    private ListView listView;

    private boolean isAlive=true;

    //声明一个适配器对象
    private MyAdapter adapter=new MyAdapter(this);
    @Override       //Bundle savedInstanceState   保存Activity的当前状态
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        initView();
        intent = new Intent(this, MediaPlayService.class);

        //开辟一个子线程，在子线程中无限次循环，循环中要做的就是获取MediaPlayer播放的歌曲的总长度以及当前歌曲的播放进度
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isAlive){
                    //因为线程刚执行的时候，服务还没有绑定
                    //也就是说myBinder对象时空的，当MyBinder对象不为空的时候
                    //说明服务已经绑定，当isPlaying返回true 说明正在播放歌曲
                    if (myBind!=null&&myBind.isPlaying()){
                        //获取值得过程可以在子线程操作
                        //但是更改UI的操作需要再主线程执行
                        //RunOnUi方法，就可以调到主线程中执行run方法里面的内容
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setMax(myBind.getDu());
                                seekBar.setProgress(myBind.getCurrentProgress());
                            }
                        });
                    }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }).start();
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBind = (MediaPlayService.MyBind) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        //绑定服务
        bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);


        //注册广播接收器
        IntentFilter intentFilter =new IntentFilter("MySong");
        songReceiver=new SongReceiver();
        registerReceiver(songReceiver,intentFilter);







    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onPause() {
        super.onPause();
        isAlive=false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(songReceiver);
        //解绑服务
        unbindService(serviceConnection);
    }

    private void initView() {
        singerNameTv= (TextView) findViewById(R.id.singer);
        songNameTv= (TextView) findViewById(R.id.song_name);
        findViewById(R.id.play_btn).setOnClickListener(this);
        findViewById(R.id.pause_btn).setOnClickListener(this);
        findViewById(R.id.lastBtn).setOnClickListener(this);
        findViewById(R.id.nextBtn).setOnClickListener(this);
        findViewById(R.id.singleplay_btn).setOnClickListener(this);
        findViewById(R.id.repeatplay_btn).setOnClickListener(this);
        findViewById(R.id.randomplay_btn).setOnClickListener(this);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        headIv= (ImageView) findViewById(R.id.head_Iv);
        listView= (ListView) findViewById(R.id.listview);
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_btn:
                if (myBind.isPlaying()) {
                    myBind.pause();
                } else {
                    //如果没播放，且现在是第一次播放
                    if (myBind.isFirst()) {
                        //那么调用play，设置url，准备、播放
                        myBind.play();
//                        改掉isFirst为false
                        myBind.setFirst();
                    } else {
                        //如果已经播放过了，说明player对象已经被设置了音乐url，则继续
                        myBind.continuePlay();
                    }
                }
                break;
            case R.id.pause_btn:
                myBind.pause();
                break;
            case R.id.lastBtn:
                myBind.playLast();
                break;
            case R.id.nextBtn:
                myBind.playNext();
                break;
            case R.id.singleplay_btn:
                myBind.singleMode();
                break;
            case R.id.repeatplay_btn:
                myBind.repeatMode();
                break;
            case R.id.randomplay_btn:
                myBind.randomMode();
                break;
        }
    }


    private void showNotify(){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        Intent intent =new Intent(this,SeondActivity.class);
//        PendingIntent PI=PendingIntent.getActivities(this,3,new Intent[]{intent},)
//        builder.setSmallIcon(R.mipmap.ic_launcher)

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
            myBind.setMediaProgress(seekBar.getProgress());
    }



    class  SongReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            SongsBean songsBean=intent.getParcelableExtra("songBean");
            songsBeen=intent.getParcelableArrayListExtra("songBeen");
            position=intent.getIntExtra("position",0);
            if (songsBean.getSingerName()==null){
                singerNameTv.setText("未知艺人");
            }else {
            singerNameTv.setText(songsBean.getSingerName());
            }
            songNameTv.setText(songsBean.getSongName());
            String albumArt= songsBean.getAlbumArt();
            Bitmap bm =null;
            if (albumArt==null){
                headIv.setBackgroundResource(R.mipmap.ic_launcher);
            }else {
                bm= BitmapFactory.decodeFile(albumArt);
                BitmapDrawable bitmapDrawable=new BitmapDrawable(bm);
                headIv.setImageDrawable(bitmapDrawable);
            }
            adapter.setDatas(songsBeen);
            listView.setAdapter(adapter);

        }
    }
}
