package com.lautung.popup_menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.PopupMenu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.buttion).setOnClickListener { it ->
            val popupMenu=PopupMenu(this,it)
            popupMenu.menuInflater.inflate(R.menu.menu_popup,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                var info = ""
                info = when (it.itemId) {
                    R.id.saosao -> "你点了扫一扫"
                    R.id.add -> "你点了添加"
                    else -> ""
                }
                true
            }
            popupMenu.show()
        }
    }
}

