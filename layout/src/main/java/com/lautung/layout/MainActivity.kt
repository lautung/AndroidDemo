package com.lautung.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_fl).apply {
            setOnClickListener {
                val mIntent = Intent(this@MainActivity,FrameLayoutActivity::class.java)
                startActivity(mIntent)
            }
        }

    }
}