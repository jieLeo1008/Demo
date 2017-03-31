package com.example.jieleo.aidlmusicdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jieleo on 2017/3/29.
 */

public class MusicBean implements Parcelable {
    private String songName;
    private String singerName;
    private Long duringTime;
    private String url;
    private String albumArt;

    public MusicBean(String songName, String singerName, Long duringTime, String url, String albumArt) {
        this.songName = songName;
        this.singerName = singerName;
        this.duringTime = duringTime;
        this.url = url;
        this.albumArt = albumArt;
    }

    protected MusicBean(Parcel in) {
        songName = in.readString();
        singerName = in.readString();
        url = in.readString();
        albumArt = in.readString();
    }

    public static final Creator<MusicBean> CREATOR = new Creator<MusicBean>() {
        @Override
        public MusicBean createFromParcel(Parcel in) {
            return new MusicBean(in);
        }

        @Override
        public MusicBean[] newArray(int size) {
            return new MusicBean[size];
        }
    };

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

    public Long getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(Long duringTime) {
        this.duringTime = duringTime;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(singerName);
        dest.writeString(url);
        dest.writeString(albumArt);
    }
}
