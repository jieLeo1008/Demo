package com.lanou.dllo.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yuyongjie on 17/1/18.
 */


public class SongsBean implements Parcelable {
    private String songName;
    private String singerName;
    private String url;
    private String albumArt;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(String albumArt) {
        this.albumArt = albumArt;
    }

    public SongsBean(String songName, String singerName, String url, String albumArt) {
        this.songName = songName;
        this.singerName = singerName;
        this.url = url;
        this.albumArt = albumArt;
    }

    protected SongsBean(Parcel in) {
        songName = in.readString();
        singerName = in.readString();
        url = in.readString();
        albumArt = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(singerName);
        dest.writeString(url);
        dest.writeString(albumArt);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SongsBean> CREATOR = new Creator<SongsBean>() {
        @Override
        public SongsBean createFromParcel(Parcel in) {
            return new SongsBean(in);
        }

        @Override
        public SongsBean[] newArray(int size) {
            return new SongsBean[size];
        }
    };
}
