package com.lautung.sensor_sample3

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() , SensorEventListener {

    private var cView: CompassView? = null
    private var sManager: SensorManager? = null
    private var mSensorOrientation: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cView = CompassView(this@MainActivity);
        sManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mSensorOrientation = sManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sManager?.registerListener(this, mSensorOrientation, SensorManager.SENSOR_DELAY_UI);
        setContentView(cView)

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.apply {
            cView?.setDegree(values[0])
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onDestroy() {
        super.onDestroy()
        sManager?.unregisterListener(this);
    }


}