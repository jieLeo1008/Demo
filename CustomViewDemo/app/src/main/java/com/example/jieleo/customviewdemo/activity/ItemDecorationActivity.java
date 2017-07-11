package com.example.jieleo.customviewdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jieleo.customviewdemo.R;
import com.example.jieleo.customviewdemo.bean.item_decoration.ItemDecorationBean;
import com.example.jieleo.customviewdemo.bean.item_decoration.NameBean;
import com.example.jieleo.customviewdemo.tool.CallBack;
import com.example.jieleo.customviewdemo.tool.NetTool;
import com.example.jieleo.customviewdemo.view.item_decoration.ItemDecorationAdapter;
import com.example.jieleo.customviewdemo.view.item_decoration.SelectionDecoration;

import java.util.ArrayList;
import java.util.List;

public class ItemDecorationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private ItemDecorationAdapter mItemDecorationAdapter;
    public String url="http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    private List<NameBean>  mNameBeen=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        mRecyclerView = (RecyclerView) findViewById(R.id.item_rv);
        mItemDecorationAdapter=new ItemDecorationAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mItemDecorationAdapter);
        NetTool.getInstance().getDataFromUrl(url, ItemDecorationBean.class, new CallBack<ItemDecorationBean>() {
            @Override
            public void onSuccess(ItemDecorationBean response) {
                mItemDecorationAdapter.setComingBeanList(response.getData().getComing());
                setPullAction(response.getData().getComing());
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d("ItemDecorationActivity", throwable.toString());
            }
        });


        mRecyclerView.addItemDecoration(new SelectionDecoration(mNameBeen, this, new SelectionDecoration.DecorationCallback() {
            @Override
            public String getGroupId(int position) {
                if(mNameBeen.get(position).getName()!=null) {
                    return mNameBeen.get(position).getName();
                }
                return "-1";
            }

            @Override
            public String getGroupFirstLine(int position) {
                if(mNameBeen.get(position).getName()!=null) {
                    return mNameBeen.get(position).getName();
                }
                return "";
            }
        }));
    }

    private void setPullAction(List<ItemDecorationBean.DataBean.ComingBean> comingslist) {


        for (int i = 0; i < comingslist.size(); i++) {
            NameBean nameBean = new NameBean();
            String name0 = comingslist.get(i).getComingTitle();
            nameBean.setName(name0);
            mNameBeen.add(nameBean);
        }
    }
}
