package com.benny.viewdemo.ui.kotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.benny.viewdemo.R
import com.benny.viewdemo.ui.java.ZakerGridActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var manager: LinearLayoutManager

    private lateinit var adapter: RvAdapter

    private lateinit var list: ArrayList<MainBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.main_rv)

        manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = manager

        list = ArrayList()

        list.add(MainBean(ZakerGridActivity::class.java, "Zaker"))

        adapter = RvAdapter(this, list)

        recyclerView.adapter = adapter


    }


    class RvAdapter(context: Context, array: ArrayList<MainBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private val context = context

        private var list = array


        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val mainHolder: MainHolder
            mainHolder = holder as MainHolder;
            mainHolder.button.setText(list.get(position).activityName)
            mainHolder.button.setOnClickListener(View.OnClickListener {
                val intent: Intent
                intent = Intent(context, list.get(position).activity)
                context.startActivity(intent)
            })
        }

        override fun getItemCount(): Int {
            return list?.size as Int
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            return MainHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false))

        }


        class MainHolder : RecyclerView.ViewHolder {
            var button: Button

            constructor(view: View) : super(view) {
                button = view.findViewById(R.id.main_btn)
            }


        }

    }


    class MainBean(activitys: Class<*>, name: String) {
        val activity = activitys
        val activityName = name

    }
}
