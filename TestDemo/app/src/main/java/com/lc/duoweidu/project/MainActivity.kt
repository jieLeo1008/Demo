package com.lc.duoweidu.project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lc.duoweidu.project.face.PermissionAcitivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent:Intent
//        intent= Intent(this,PermissionAcitivity::class.java)
        intent= Intent(this,PostTestActivity::class.java)
        startActivity(intent)

    }
}
