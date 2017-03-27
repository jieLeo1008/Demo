package com.example.jieleo.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mShowButton;
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mShowButton = (Button) findViewById(R.id.show_btn);
        mShowButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showNotification();
    }

    private void showNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        Intent toSecond = new Intent(this, SecondActivity.class);
        int requestCode = 3;
        toSecond.putExtra("num", 10);
        PendingIntent toSecondPI = PendingIntent.getActivities(this, requestCode, new Intent[]{toSecond}, PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText("哈哈").setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(bitmap)
                .setCustomContentView(getRemoteViews())
                .setContentIntent(toSecondPI).setAutoCancel(true).setTicker("司帅");
        mNotificationManager.notify(10, builder.build());
    }

    private RemoteViews getRemoteViews(){
        RemoteViews remoteViews=new RemoteViews(getPackageName(),R.layout.item_notification);
        remoteViews.setTextViewText(R.id.title_tv,"哈哈");
        Intent toSecondAty=new Intent(this,SecondActivity.class);
        toSecondAty.putExtra("key","title");
        PendingIntent titlePI=PendingIntent.getActivities(this,3,new Intent[]{toSecondAty},0);
        remoteViews.setOnClickPendingIntent(R.id.title_tv,titlePI);
        return remoteViews;
    }
}
