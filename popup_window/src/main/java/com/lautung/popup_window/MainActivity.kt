package com.lautung.popup_window

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_show).setOnClickListener{
            val view=LayoutInflater.from(this@MainActivity).inflate(R.layout.item_popip,null)
            val btnXixi=view.findViewById<Button>(R.id.btn_xixi)
            val btnHehe=view.findViewById<Button>(R.id.btn_hehe)
            val popupWindow=PopupWindow(view,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true)
            popupWindow.animationStyle = R.anim.anim_pop;  //设置加载动画
            popupWindow.isTouchable = true;
            popupWindow.setTouchInterceptor{_,_->
                false
            }

            popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
            popupWindow.showAsDropDown(it, 0, 0)
            btnXixi.setOnClickListener{
                Toast.makeText(this@MainActivity, "你点击了嘻嘻~", Toast.LENGTH_SHORT).show();
            }
            btnHehe.setOnClickListener{
                Toast.makeText(this@MainActivity, "你点击了呵呵~", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }

        }

    }
}