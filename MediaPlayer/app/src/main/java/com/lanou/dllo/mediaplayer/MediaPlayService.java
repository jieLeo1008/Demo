package com.lanou.dllo.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuyongjie on 17/1/18.
 */


public class MediaPlayService extends Service {
    private static final String TAG = "MediaPlayService";
    //声明一个Media对象
    private MediaPlayer mediaPlayer;

    //声明一个装载音乐信息的集合
    private List<SongsBean> songsBeen;

    //声明一个歌曲位置信息的变量
    private int index;

    private MyBind myBind;

    private boolean isFirst = true;

    private int playMode = 1;
    private int number;

    @Override
    public void onCreate() {
        super.onCreate();
        myBind = new MyBind();
        //初始化MediaPlayer对象
        mediaPlayer = new MediaPlayer();
        //初始化音乐信息的集合
        songsBeen = new ArrayList<>();
        //设置对mediaPlayer完成播放的监听
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (playMode == 0) {
                    mediaPlayer.reset();
                    myBind.play();
                } else if (playMode == 1) {
                    index++;
                    mediaPlayer.reset();
                    myBind.play();
                } else if (playMode == 2) {
                    //获得一个随机数并且不和index相等
                    do {
                        number = (int) (Math.random() * (songsBeen.size() - 1));
                    } while (index == number);
                    index = number;
                    mediaPlayer.reset();
                    myBind.play();
                }
            }
        });
        //获取音乐
        getMusicData();
        Intent intent = new Intent("MySong");
        intent.putParcelableArrayListExtra("songBeen", (ArrayList<? extends Parcelable>) songsBeen);

        intent.putExtra("songBean", songsBeen.get(0));
        sendBroadcast(intent);

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.reset();
        //释放资源
        mediaPlayer.release();
        return super.onUnbind(intent);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public void getMusicData() {

        //根据uri找到所有的音频信息
        Cursor cursor = getContentResolver().
                query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {

            do {
                //获取音乐的名字
                String title = cursor.getString(
                        cursor.getColumnIndex(
                                MediaStore.Audio.Media.TITLE));
                //歌手名字
                String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //获取歌曲的url
                String url = cursor.getString
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DATA));
                //获取音乐类型 0 代表不是音乐
                int isMusic = cursor.getInt
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.IS_MUSIC));
                //获取音乐的时长
                Long duringTime = cursor.getLong
                        (cursor.getColumnIndex
                                (MediaStore.Audio.Media.DURATION));
                String Id=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                Log.e(TAG, "getMusicData: "+"++++++++++++++++++++"+Id );
                int id=Integer.valueOf(Id);
                String albumArt=getAlbumArt(id);
                if (isMusic != 0 && duringTime / 60 * 1000 > 1) {
                    SongsBean bean = new SongsBean(title, singer, url,albumArt);
                    songsBeen.add(bean);
                }


            } while (cursor.moveToNext());
            for (SongsBean bean : songsBeen) {
                Log.e("MyService", bean.getSongName() + " " + bean.getSingerName() + " " + bean.getUrl()+"    "+bean.getAlbumArt() );
            }
        }
        //关闭游标
        cursor.close();
    }

    private String getAlbumArt(int Id) {
        String mUriAlbums = "content://media/external/audio/albums";
        String[] projection = new String[] { "album_art" };
        Cursor cur = this.getContentResolver().query(  Uri.parse(mUriAlbums + "/" + Integer.toString(Id)),  projection, null, null, null);
        String album_art = null;
        if (cur.getCount() > 0 && cur.getColumnCount() > 0)
        {  cur.moveToNext();
            album_art = cur.getString(0);
        }
        cur.close();
        Log.e(TAG, "getAlbumArt: "+"__________-------"+album_art );
        return album_art;
    }


    class MyBind extends Binder {

        public MyBind() {
        }

        public void play() {
            SongsBean songsBean = songsBeen.get(index);
            try {
                //设置要播放的音乐资源，这个地址是内容是从提供者获得的
                mediaPlayer.setDataSource(songsBean.getUrl());
                //准备
                mediaPlayer.prepare();
                //播放
                mediaPlayer.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent("MySong");
            intent.putExtra("songBean", songsBean);

            intent.putParcelableArrayListExtra("songBeen", (ArrayList<? extends Parcelable>) songsBeen);
            intent.putExtra("position",index);
            sendBroadcast(intent);
        }

        /**
         * @return mediaplayer是否正在播放
         */
        public boolean isPlaying() {
            return mediaPlayer.isPlaying();
        }


        public void pause() {
            mediaPlayer.pause();
        }


        public void continuePlay() {
            mediaPlayer.start();
        }


        public boolean isFirst() {
            return isFirst;
        }

        public void setFirst() {
            isFirst = false;
        }

        public void playLast() {
            if (playMode == 1 || playMode == 0) {
                index--;
                if (index < 0) {
                    index = songsBeen.size() - 1;
                }
                mediaPlayer.reset();
                play();
            } else if (playMode == 2) {
                do {
                    number = (int) (Math.random() * (songsBeen.size() - 1));
                } while (index == number);
                index = number;
                mediaPlayer.reset();
                play();
            }
        }

        public void playNext() {
            if (playMode == 0 || playMode == 1) {
                index++;
                if (index >= songsBeen.size()) {
                    index = 0;
                }
                mediaPlayer.reset();
                play();
            } else if (playMode == 2) {
                do {
                    number = (int) (Math.random() * (songsBeen.size() - 1));
                } while (index == number);
                index = number;
                mediaPlayer.reset();
                play();
            }
        }

        public int getDu() {
            return mediaPlayer.getDuration();
        }

        public int getCurrentProgress() {
            return mediaPlayer.getCurrentPosition();
        }

        public void setMediaProgress(int progress) {
            mediaPlayer.seekTo(progress);
        }

        public void randomMode() {
            playMode = 2;
        }

        public void repeatMode() {
            playMode = 1;
        }

        public void singleMode() {
            playMode = 0;
        }


    }

}
