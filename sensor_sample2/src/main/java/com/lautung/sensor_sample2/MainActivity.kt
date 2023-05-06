package com.lautung.sensor_sample2

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), SensorListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this@MainActivity,SensorManager.SENSOR_DELAY_UI)
    }

    override fun onSensorChanged(p0: Int, floatArray: FloatArray) {
        this@MainActivity.findViewById<TextView>(R.id.tv1).text = "方位角：${Math.round(floatArray.get(0)*100)/100}"
        this@MainActivity.findViewById<TextView>(R.id.tv2).text = "倾斜角：${Math.round(floatArray.get(1)*100)/100}"
        this@MainActivity.findViewById<TextView>(R.id.tv3).text = "滚动角：${Math.round(floatArray.get(2)*100)/100}"
    }

    override fun onAccuracyChanged(p0: Int, p1: Int) {

    }
}


