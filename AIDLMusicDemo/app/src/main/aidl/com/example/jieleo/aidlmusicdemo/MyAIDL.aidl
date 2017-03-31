// MyAIDL.aidl
package com.example.jieleo.aidlmusicdemo;
import com.example.jieleo.aidlmusicdemo.MusicBean;

// Declare any non-default types here with import statements

interface MyAIDL {

    void playNext();
    void playLast();
    void playMusic();
    void pauseMusic();
    boolean isPlaying();
    void countinuePlay();
    void setFirst();
    boolean isFirst();
    int getDuringTime();
    int getCurrentProgress();
    void setCurrentProgress(int progress);
    void setMediaProgress(int progress);
    MusicBean getMusicData();
    List<MusicBean> getMusicList();
}
