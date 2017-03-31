package com.example.jieleo.aidlmusicdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.RemoteViews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicService extends Service {
    private List<MusicBean> mMusicBeen;
    private int index;
    private boolean isFirst;
    private MyBinder mBinder;
    private MediaPlayer mMediaPlayer;

    private Notification.Builder mBuilder;
    private NotificationManager mNotificationManager;
    private RemoteViews mRemoteViews;

    private MyBroadCastRecriver mBroadCastRecriver;

    public MusicService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBinder=new MyBinder();
        mMusicBeen=new ArrayList<>();
        //初始化MediaPlayer
        mMediaPlayer=new MediaPlayer();
        //初始化NotificationManager
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        mRemoteViews=new RemoteViews(getPackageName(),R.layout.item_nitification);

        mBuilder=new Notification.Builder(this);

        mBroadCastRecriver=new MyBroadCastRecriver();

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("playNow");
        intentFilter.addAction("playNext");
        intentFilter.addAction("playLast");

        registerReceiver(mBroadCastRecriver,intentFilter);

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                index++;
                mMediaPlayer.reset();
                try {
                    mBinder.playMusic();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        getMusicData();
    }

    private void getMusicData() {
        Cursor cursor=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,null);
        if (cursor!=null&&cursor.moveToFirst()){
            do {
                //获取音乐的名字
                String title=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                //歌手名字
                String singer=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //获取歌曲的Url
                String url=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                //获取音乐类型 0代表不是音乐
                int isMusic=cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长
                Long duringTime=cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                //获取封面的Id
                String albumId =cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                String albumArt=getAlbumArt(Integer.valueOf(albumId));
                if (isMusic!=0&&duringTime/60*1000>1){
                    MusicBean musicBean=new MusicBean(title,singer,duringTime,url,albumArt);
                    mMusicBeen.add(musicBean);
                    Log.d("MusicService", "duringTime:" + duringTime);
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    private String getAlbumArt(Integer id) {
        String mUriAlbums = "content://media/external/audio/albums";
        String[] projection=new String[]{"album_art" };
        Cursor cursor=this.getContentResolver().query(Uri.parse(mUriAlbums + "/" + Integer.toString(id)),projection,null,null,null);
        String album_art=null;
        if (cursor.getCount()>0&&cursor.getColumnCount()>0){
            cursor.moveToNext();
            album_art=cursor.getString(0);
        }
        cursor.close();
        return album_art;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
//        mMediaPlayer.reset();
//        mMediaPlayer.release();
//        Log.d("MusicService", "音乐播放服务finish了");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadCastRecriver);
    }

    public  void  refreshNotification(){
        mRemoteViews.setTextViewText(R.id.tv_song_name_notification, mMusicBeen.get(index).getSongName());
        mRemoteViews.setTextViewText(R.id.tv_singer_name_nitification,mMusicBeen.get(index).getSingerName());

        mRemoteViews.setImageViewBitmap(R.id.iv_notification, BitmapFactory.decodeFile(mMusicBeen.get(index).getAlbumArt()));

        mRemoteViews.setImageViewResource(R.id.iv_last_notification,R.mipmap.ic_launcher_round);
        mRemoteViews.setImageViewResource(R.id.iv_next_notification,R.mipmap.ic_launcher_round);


        try {
            Log.d("MusicService", "mBinder.isPlaying():" + mBinder.isPlaying());
            if (mBinder.isPlaying())
            {
                mRemoteViews.setImageViewResource(R.id.iv_play_notification,R.mipmap.ic_launcher);
                Log.d("MusicService", "ic_launcher");
            }else
            {
                mRemoteViews.setImageViewResource(R.id.iv_play_notification,R.mipmap.ic_launcher_round);
                Log.d("MusicService", "ic_launcher_round");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Intent playIntent=new Intent("playNow");
        Intent playNext=new Intent("playNext");
        Intent playLast=new Intent("playLast");

        PendingIntent playPendingIntent=PendingIntent.getBroadcast(this,2,playIntent,PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent lastPendingIntent=PendingIntent.getBroadcast(this,2,playLast,PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent nextPendingIntent=PendingIntent.getBroadcast(this,2,playNext,PendingIntent.FLAG_CANCEL_CURRENT);

        mRemoteViews.setOnClickPendingIntent(R.id.iv_play_notification,playPendingIntent);
        mRemoteViews.setOnClickPendingIntent(R.id.iv_last_notification,lastPendingIntent);
        mRemoteViews.setOnClickPendingIntent(R.id.iv_next_notification,nextPendingIntent);

        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round).setContent(mRemoteViews);

        mNotificationManager.notify(1,mBuilder.build());
    }


    class MyBinder extends MyAIDL.Stub{

        @Override
        public void playNext() throws RemoteException {
            index++;
            if (index==mMusicBeen.size()){
                index=0;
            }
            mMediaPlayer.reset();
            playMusic();
            refreshNotification();
        }

        @Override
        public void playLast() throws RemoteException {
            index--;
            if (index==0){
                index=mMusicBeen.size()-1;
            }
            mMediaPlayer.reset();
            playMusic();
            refreshNotification();
        }

        @Override
        public void playMusic() throws RemoteException {
                MusicBean musicBean=mMusicBeen.get(index);
            try {
                mMediaPlayer.setDataSource(musicBean.getUrl());
                mMediaPlayer.prepare();
                mMediaPlayer.start();
                refreshNotification();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void pauseMusic() throws RemoteException {
            mMediaPlayer.pause();
            refreshNotification();
        }

        @Override
        public boolean isPlaying() throws RemoteException {
            return mMediaPlayer.isPlaying();
        }

        @Override
        public void countinuePlay() throws RemoteException {
            mMediaPlayer.start();
            refreshNotification();
        }

        @Override
        public void setFirst() throws RemoteException {
            isFirst=false;
        }

        @Override
        public boolean isFirst() throws RemoteException {
            return isFirst;
        }

        @Override
        public int getDuringTime() throws RemoteException {
            return mMediaPlayer.getDuration();
        }

        @Override
        public int getCurrentProgress() throws RemoteException {
            return mMediaPlayer.getCurrentPosition();
        }

        @Override
        public void setCurrentProgress(int progress) throws RemoteException {
            mMediaPlayer.seekTo(progress);
        }

        @Override
        public void setMediaProgress(int progress) throws RemoteException {
            mMediaPlayer.seekTo(progress);
        }

        @Override
        public MusicBean getMusicData() throws RemoteException {
            MusicBean musicBean=mMusicBeen.get(index);
            return musicBean;
        }

        @Override
        public List<MusicBean> getMusicList() throws RemoteException {
            return mMusicBeen;
        }
    }

    class MyBroadCastRecriver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "playNow":
                    try {
                        if (mBinder.isPlaying())
                        {
                            mBinder.pauseMusic();
                        }else {
                            if (isFirst){
                            mBinder.playMusic();
                            }else {
                                mBinder.countinuePlay();
                            }
                        }
                        break;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                case "playNext":
                    try {
                        mBinder.playNext();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                case "playLast":
                    try {
                        mBinder.playLast();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }



}
