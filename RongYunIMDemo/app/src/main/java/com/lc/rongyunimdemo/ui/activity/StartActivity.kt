package com.lc.rongyunimdemo.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.lc.rongyunimdemo.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        Handler().postDelayed(Runnable {
            startActivity(Intent().setClass(this,MainActivity::class.java))
            finish()
        },2000)



    }
}
