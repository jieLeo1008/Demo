package com.jieleo.mysimpledemo.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jieleo.mysimpledemo.R
import com.jieleo.mysimpledemo.java.activity.ExtractQRCodeActivity
import com.jieleo.mysimpledemo.java.adapter.MainRvAdapter
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), MainRvAdapter.MyOnclickListener {

    private lateinit var recyclerView: RecyclerView

    private lateinit var layoutManager: RecyclerView.LayoutManager


    private var title = ArrayList<String>()

    private lateinit var rvAdapter: MainRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addDate()

        recyclerView = find(R.id.main_rv)

        rvAdapter = MainRvAdapter(this)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = rvAdapter

        rvAdapter.setTitle(title)

        rvAdapter.setListener(this)
    }


    override fun onClickBtn(pos: Int) {
        when (pos) {
            0 -> {
                startActivity(Intent(this,ExtractQRCodeActivity::class.java).putExtra("title","识别二维码"))
            }
            1 -> {

            }

            else -> {

            }
        }
    }

    private fun addDate() {
        title.add("识别二维码")

        title.add("第二个")

        title.add("第三个")
    }



}


