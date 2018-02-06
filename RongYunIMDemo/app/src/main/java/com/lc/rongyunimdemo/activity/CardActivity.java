package com.lc.rongyunimdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.view.View;

import com.lc.rongyunimdemo.R;
import com.lc.rongyunimdemo.view.stackcardview.StackCardsView;

public class CardActivity extends AppCompatActivity {

    private StackCardsView mStackCardsView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        mStackCardsView=findViewById(R.id.stack_card_view);


    }





}
