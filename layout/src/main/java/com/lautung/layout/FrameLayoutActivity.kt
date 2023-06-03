package com.lautung.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class FrameLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)
        findViewById<FrameLayout>(R.id.fl).apply {
            val meiziview = MeiZiView(this.context)

            addView(meiziview)
        }
    }
}

