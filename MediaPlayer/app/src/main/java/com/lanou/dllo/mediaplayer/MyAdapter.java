package com.lanou.dllo.mediaplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jie on 2017/1/30.
 */

public class MyAdapter extends BaseAdapter{
    private ArrayList<SongsBean> datas;
    private Context context;
    private  ImageView headIv;
    private TextView songsNameTv,singerNameTv;

    public MyAdapter( Context context) {
        this.context = context;
    }

    public MyAdapter() {
    }

    public void setDatas(ArrayList<SongsBean> datas) {
        this.datas = datas;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =null;
    if (convertView==null){
        view=LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
    }else {
        view=convertView;
    }
        headIv= (ImageView) view.findViewById(R.id.head_list_iv);
        songsNameTv= (TextView) view.findViewById(R.id.song_name_list_tv);
        singerNameTv= (TextView) view.findViewById(R.id.singer_list_tv);
        String albumArt=null;
        albumArt=datas.get(position).getAlbumArt();
        if (albumArt==null){
            headIv.setBackgroundResource(R.mipmap.ic_launcher);
        }else {
            Bitmap bm= BitmapFactory.decodeFile(albumArt);
            BitmapDrawable bitmapDrawable=new BitmapDrawable(bm);
            headIv.setImageDrawable(bitmapDrawable);
        }
        songsNameTv.setText(datas.get(position).getSongName());
        if (datas.get(position).getSingerName()==null){
            singerNameTv.setText("未知艺人");
        }else {
        singerNameTv.setText(datas.get(position).getSingerName());
        }
        return view;
    }


}
