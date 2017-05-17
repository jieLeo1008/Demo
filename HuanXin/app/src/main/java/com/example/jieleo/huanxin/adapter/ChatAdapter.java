package com.example.jieleo.huanxin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jieleo.huanxin.R;
import com.example.jieleo.huanxin.bean.MyChatBean;
import com.hyphenate.chat.EMMessage;

import java.util.List;

/**
 * Created by OldFour on 2017/5/12.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private List<MyChatBean> mChatBeen;

    public final int RECEIVE = 0;
    public final int SEND = 1;

    public ChatAdapter(Context context) {
        mContext = context;
    }

    public ChatAdapter setChatBeen(List<MyChatBean> chatBeen) {
        mChatBeen = chatBeen;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case RECEIVE:
                View receive = LayoutInflater.from(mContext).inflate(R.layout.ietm_receive, parent, false);
                viewHolder = new RecMsgViewHolder(receive);
                break;
            case SEND:
                View send = LayoutInflater.from(mContext).inflate(R.layout.ietm_send, parent, false);
                viewHolder = new SendMsgViewHolder(send);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyChatBean.ContactMsg contactMsg = mChatBeen.get(position).getContactMsg();
        switch (getItemViewType(position)) {
            case RECEIVE:
                RecMsgViewHolder holder1 = (RecMsgViewHolder) holder;
                holder1.mTextView.setText(contactMsg.getMsg());
                break;
            case SEND:
                SendMsgViewHolder holder2= (SendMsgViewHolder) holder;
                holder2.mTextView.setText(contactMsg.getMsg());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mChatBeen != null ? mChatBeen.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        MyChatBean.ContactMsg contactMsg = mChatBeen.get(position).getContactMsg();
        if (contactMsg.getType() == RECEIVE) {
            return RECEIVE;
        } else {
            return SEND;
        }

    }

    public class RecMsgViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public RecMsgViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.receive_tv);
        }
    }

    public class SendMsgViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public SendMsgViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.send_tv);
        }
    }
}
