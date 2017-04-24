package com.example.jieleo.testramdemo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    //内存抖动
    private int rowLength=10;
    private int length=420000;
    private Random ran=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
        calcuate();
    }

    /**
     * 计算每个App可以使用的内存
     */
    private void calcuate() {
        StringBuilder stringBuilder=new StringBuilder();

        //得到activityManager
        ActivityManager activityManager= (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        int memClass=activityManager.getMemoryClass();  //以M为单位

        int memLargeClass=activityManager.getLargeMemoryClass();  //以M为单位

        stringBuilder.append("memClass"+memClass+"\n");
        stringBuilder.append("memLargeClass"+memLargeClass+"\n");

        Float totalMemory =Runtime.getRuntime().totalMemory()*1.0f/(1024*1024);

        Float freeMemory =Runtime.getRuntime().freeMemory()*1.0f/(1024*1024);
        Float maxMemory =Runtime.getRuntime().maxMemory()*1.0f/(1024*1024);
        stringBuilder.append("maxMemory"+maxMemory+"\n").append("freeMemory"+freeMemory+"\n").append("totalMemory"+totalMemory+"\n");

        mTextView.setText(stringBuilder.toString());

        Log.d("MainActivity", stringBuilder.toString());


    }

    /**
     * 内存抖动
     * @param view
     */
    public void makeShake(View view){
        Log.d("MainActivity", "start");
        for (int i = 0; i < rowLength; i++) {
            String[] strMartix=new String[length];
            for (int j = 0; j < length; j++) {
                strMartix[j]=String.valueOf(ran.nextDouble());
            }
            Log.d("MainActivity", "doChurn  rowStr" + i);
        }
        Log.d("MainActivity", "doCurn rowStr end");
    }

    /**
     * 跳转到第二页
     * @param view
     */
    public void toSecond(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }

    /**
     * App性能优化
     * 1、数据结构优化
     *  频繁的字符串拼接使用StringBuilder
     *  ArrayMap、SparseArray替换HashMap  （占用资源少）
     *  内存抖动（变量使用不当）
     *  最小的Class也需要0.5Kb
     *  HashMap的每一个entry需要额外的32B
     * 2、对象的复用
     *  复用系统自带的资源
     *  ListView/GridView的ConvertView复用
     *  避免在onDraw方法里面执行对象的创建（频繁执行）
     * 3、避免内存泄漏
     * （内存泄漏会导致可用的Heap越来越少，频繁触发Gc） 当Heap越来越小的时候会频繁的触发Gc 影响性能
     *  Activity的泄漏
     *  使用Application的Context而不是Activity的Context
     *  注意Cursor对象是否及时关闭
     */


    /**
     * OOM问题分析
     * 1、OOM的必然性与可解决性
     * 2、OOM的绝大部分发生在图片
     */


    /**
     * 检测系统内存的响应
     * @param level  相应等级
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level==TRIM_MEMORY_UI_HIDDEN){
            Toast.makeText(this, "程序已经切换到后台", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 优化OOM问题的方法
     * 1、注意临时BitMap对象的回收
     * 2、避免BItmap的浪费
     * 3、Try Catch某些大内存的分配操作
     * 4、加载Bitmap：缩放比例、解码格式、局部加载
     */
}
