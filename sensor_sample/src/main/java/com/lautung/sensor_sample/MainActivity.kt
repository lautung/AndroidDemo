package com.lautung.sensor_sample

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mSensorManager:SensorManager
    private lateinit var mTvShow:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mTvShow = findViewById<TextView>(R.id.tv_show)

        val allSensors: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        val sb = StringBuilder()

        sb.append("此手机有" + allSensors.size + "个传感器，分别有：\n\n")
        for (s: Sensor in allSensors) {
            when (s.type) {
                Sensor.TYPE_ACCELEROMETER -> sb.append(s.type.toString() + " 加速度传感器(Accelerometer sensor)" + "\n")
                Sensor.TYPE_GYROSCOPE -> sb.append(s.type.toString() + " 陀螺仪传感器(Gyroscope sensor)" + "\n")
                Sensor.TYPE_LIGHT -> sb.append(s.type.toString() + " 光线传感器(Light sensor)" + "\n")
                Sensor.TYPE_MAGNETIC_FIELD -> sb.append(s.type.toString() + " 磁场传感器(Magnetic field sensor)" + "\n")
                Sensor.TYPE_ORIENTATION -> sb.append(s.type.toString() + " 方向传感器(Orientation sensor)" + "\n")
                Sensor.TYPE_PRESSURE -> sb.append(s.type.toString() + " 气压传感器(Pressure sensor)" + "\n")
                Sensor.TYPE_PROXIMITY -> sb.append(s.type.toString() + " 距离传感器(Proximity sensor)" + "\n")
                Sensor.TYPE_TEMPERATURE -> sb.append(s.type.toString() + " 温度传感器(Temperature sensor)" + "\n")
                else -> sb.append(s.type.toString() + " 其他传感器" + "\n")
            }
            sb.append(
                "设备名称：" + s.name + "\n 设备版本：" + s.version + "\n 供应商："
                        + s.vendor + "\n\n" + s.resolution
            )
        }
        mTvShow.text = sb.toString()

    }
}