package com.example.jieleo.dialogdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wevey.selector.dialog.DialogOnClickListener;
import com.wevey.selector.dialog.DialogOnItemClickListener;
import com.wevey.selector.dialog.MDAlertDialog;
import com.wevey.selector.dialog.MDEditDialog;
import com.wevey.selector.dialog.MDSelectionDialog;
import com.wevey.selector.dialog.NormalAlertDialog;
import com.wevey.selector.dialog.NormalSelectionDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.bottom_select_btn)
    Button mBottomSelectBtn;
    @BindView(R.id.center_select_btn)
    Button mCenterSelectBtn;
    @BindView(R.id.center_select_single_btn)
    Button mCenterSelectSingleBtn;
    @BindView(R.id.MD_select_btn)
    Button mMDSelectBtn;
    @BindView(R.id.MD_center_select_btn)
    Button mMDCenterSelectBtn;
    @BindView(R.id.MD_editText_btn)
    Button mMDEditTextBtn;
    private NormalAlertDialog mDialog3;
    private NormalAlertDialog mNormalAlertDialog2;
    private ArrayList<String> datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bottom_select_btn, R.id.center_select_btn, R.id.center_select_single_btn, R.id.MD_select_btn, R.id.MD_center_select_btn, R.id.MD_editText_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottom_select_btn:
                NormalSelectionDialog normalSelectionDialog=new NormalSelectionDialog.Builder(this)
                        .setlTitleVisible(true) //设置是否显示标题
                        .setTitleHeight(65)//设置标题高度
                        .setTitleText("请选择")//设置标题文本
                        .setTitleTextSize(14)//设置标题字体大小 sp
                        .setTitleTextColor(R.color.colorPrimary)//设置标题文本颜色
                        .setItemHeight(40)  //设置item高度
                        .setItemWidth(0.9f) //屏幕宽度的 0.9f
                        .setItemTextColor(R.color.colorPrimaryDark)//设置item的字体颜色
                        .setItemTextSize(14)//设置item的字体大小
                        .setCancleButtonText("Cancel")//设置底部取消按钮的文本
                        .setOnItemListener(new DialogOnItemClickListener() {
                            @Override
                            public void onItemClick(Button button, int position) {
                                Toast.makeText(MainActivity.this, "第" + position + "条", Toast.LENGTH_SHORT).show();
                            }
                        }).setCanceledOnTouchOutside(true)//设置是否可以点击其他地方取消dialog
                        .build();
                ArrayList<String> strings=new ArrayList<>();
                strings.add("第一条");
                strings.add("第二条");
                strings.add("第三条");
                strings.add("第四条");
                normalSelectionDialog.setDataList(strings);
                normalSelectionDialog.show();
                break;
            case R.id.center_select_btn:
                mNormalAlertDialog2 = new NormalAlertDialog.Builder(this)
                        .setHeight(0.23f)//屏幕高度0.23
                        .setWidth(0.65f)//屏幕宽度0.65
                        .setTitleVisible(true)//
                        .setTitleText("温馨提示")
                        .setTitleTextColor(R.color.black_light)
                        .setContentText("是否关闭对话框")
                        .setContentTextColor(R.color.black_light)
                        .setLeftButtonText("关闭")
                        .setLeftButtonTextColor(R.color.gray)
                        .setRightButtonText("不关闭")
                        .setRightButtonTextColor(R.color.black_light)
                        .setOnclickListener(new DialogOnClickListener() {
                            @Override
                            public void clickLeftButton(View view) {
                                Toast.makeText(MainActivity.this, "点击了左面的按钮", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void clickRightButton(View view) {
                                Toast.makeText(MainActivity.this, "点击了右面的按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
                mNormalAlertDialog2.show();
                break;
            case R.id.center_select_single_btn:
                mDialog3 = new NormalAlertDialog.Builder(MainActivity.this)
                        .setHeight(0.23f)  //屏幕高度*0.23
                        .setWidth(0.65f)  //屏幕宽度*0.65
                        .setTitleVisible(true)
                        .setTitleText("温馨提示")
                        .setTitleTextColor(R.color.colorPrimary)
                        .setContentText("是否关闭对话框？")
                        .setContentTextColor(R.color.colorPrimaryDark)
                        .setSingleMode(true)
                        .setSingleButtonText("关闭")
                        .setSingleButtonTextColor(R.color.colorAccent)
                        .setCanceledOnTouchOutside(true)
                        .setSingleListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mDialog3.dismiss();
                            }
                        })
                        .build();
                mDialog3.show();
                break;
            case R.id.MD_select_btn:
                MDAlertDialog dialog4 = new MDAlertDialog.Builder(MainActivity.this)
                        .setHeight(0.21f)  //屏幕高度*0.21
                        .setWidth(0.7f)  //屏幕宽度*0.7
                        .setTitleVisible(true)
                        .setTitleText("温馨提示")
                        .setTitleTextColor(R.color.black_light)
                        .setContentText("确定发送文件？")
                        .setContentTextColor(R.color.black_light)
                        .setLeftButtonText("不发送")
                        .setLeftButtonTextColor(R.color.gray)
                        .setRightButtonText("发送")
                        .setRightButtonTextColor(R.color.black_light)
                        .setTitleTextSize(16)
                        .setContentTextSize(14)
                        .setButtonTextSize(14)
                        .setOnclickListener(new DialogOnClickListener() {
                            @Override
                            public void clickLeftButton(View view) {
//                        dialog4.dismiss();
                                Toast.makeText(MainActivity.this, "点击了左面的按钮", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void clickRightButton(View view) {
//                        dialog4.dismiss();
                                Toast.makeText(MainActivity.this, "点击了右面的按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();

                dialog4.show();
                break;
            case R.id.MD_center_select_btn:
                MDSelectionDialog dialog5 = new MDSelectionDialog.Builder(MainActivity.this)
                        .setCanceledOnTouchOutside(true)
                        .setItemTextColor(R.color.black_light)
                        .setItemHeight(50)
                        .setItemWidth(0.8f)  //屏幕宽度*0.8
                        .setItemTextSize(15)
                        .setCanceledOnTouchOutside(true)
                        .setOnItemListener(new DialogOnItemClickListener() {
                            @Override
                            public void onItemClick(Button button, int position) {
                                Toast.makeText(MainActivity.this, datas.get(position), Toast.LENGTH_SHORT).show();
//                        dialog5.dismiss();
                            }
                        })
                        .build();
                datas = new ArrayList<>();
                datas.add("标为未读");
                datas.add("置顶聊天");
                datas.add("删除该聊天");
                dialog5.setDataList(datas);
                dialog5.show();
                break;
            case R.id.MD_editText_btn:
                MDEditDialog dialog6 = new MDEditDialog.Builder(MainActivity.this)
                        .setTitleVisible(true)
                        .setTitleText("修改用户名")
                        .setTitleTextSize(20)
                        .setTitleTextColor(R.color.black_light)
//                        .setContentText("Weavey")
                        .setContentTextSize(18)
                        .setMaxLength(12)
//                        .setHintText("7位字符")
                        .setMaxLines(1)
                        .setContentTextColor(R.color.colorPrimary)
                        .setButtonTextSize(14)
                        .setLeftButtonTextColor(R.color.colorPrimary)
                        .setLeftButtonText("取消")
                        .setRightButtonTextColor(R.color.colorPrimary)
                        .setRightButtonText("确定")
                        .setLineColor(R.color.colorPrimary)
                        .setOnclickListener(new MDEditDialog.OnClickEditDialogListener() {
                            @Override
                            public void clickLeftButton(View view, String text) {
                                //text为编辑的内容
                                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void clickRightButton(View view, String text) {
                                //text为编辑的内容
                                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMinHeight(0.3f)
                        .setWidth(0.8f)
                        .build();
                dialog6.show();
                break;
        }
    }



}
