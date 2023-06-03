package com.lautung.layout

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

/**
 * @Auther: lautung
 * @datetime: 2023/6/3
 * @desc:
 */


class MeiZiView(context: Context?) : View(context) {
    //定义相关变量,依次是妹子显示位置的X,Y坐标
    var bitmapX: Float
    var bitmapY: Float
    var paint:Paint
    lateinit var bitmap:Bitmap

    init {
        //设置妹子的起始坐标
        bitmapX = 0f
        bitmapY = 200f
        //创建,并且实例化Paint的对象
         paint = Paint()
        //根据图片生成位图对象
         bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.s_jump)
    }

    //重写View类的onDraw()方法
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制萌妹子
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint)
        //判断图片是否回收,木有回收的话强制收回图片
        if (bitmap.isRecycled) {
            bitmap.recycle()
        }
    }
}