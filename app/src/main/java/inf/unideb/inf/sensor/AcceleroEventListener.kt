package inf.unideb.inf.sensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.ProgressBar

class AcceleroEventListener(val horizontal: ProgressBar,val vertical: ProgressBar): SensorEventListener {
//    var bias_hor = -4
//    var bias_ver =  4
    override fun onSensorChanged(p0: SensorEvent?) {
        horizontal.progress = ((p0!!.values[0] + 9.7) * 10).toInt()
        vertical.progress = ((p0.values[1] + 9.7) * 10).toInt()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}