package com.benny.viewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.benny.viewdemo.R;
import com.benny.viewdemo.model.ZakerModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Benny on 2018/3/6.
 */

public class ZakerRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private List<ZakerModel> mZakerModelList;

    public ZakerRvAdapter(Context context, List<ZakerModel> zakerModelList) {
        this.context = context;
        mZakerModelList = zakerModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ZakerHolder(LayoutInflater.from(context).inflate(R.layout.item_zaker, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ZakerHolder zakerHolder = (ZakerHolder) holder;
        zakerHolder.mZakerTv.setText(mZakerModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mZakerModelList != null ? mZakerModelList.size() : 0;
    }


    public class ZakerHolder extends RecyclerView.ViewHolder {

        TextView mZakerTv;

        ImageView mZakerIv;

        public ZakerHolder(View itemView) {
            super(itemView);
            mZakerTv=itemView.findViewById(   R.id.zaker_tv);
            mZakerIv=itemView.findViewById(R.id.zaker_iv);
        }
    }


}
