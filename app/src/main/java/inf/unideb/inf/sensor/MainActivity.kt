package inf.unideb.inf.sensor

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.Window
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity(){

    private var progressBarHor: ProgressBar? = null
    private var progressBarVer: ProgressBar? = null
    lateinit var sensorManager: SensorManager
    lateinit var sensor: Sensor
    lateinit var textView: TextView
    lateinit var acceleroEventListener: AcceleroEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBarHor = findViewById<ProgressBar>(R.id.progressBarHorizontal) as ProgressBar
        progressBarVer = findViewById<ProgressBar>(R.id.progressBarVertical) as ProgressBar

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        textView = findViewById(R.id.Text)
        textView.movementMethod = ScrollingMovementMethod()

        acceleroEventListener = AcceleroEventListener(progressBarHor!!,progressBarVer!!,textView)

        sensorManager.registerListener(acceleroEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onStart() {
        super.onStart()
        print("onStart")
    }

    override fun onResume() {
        super.onResume()
        print("onResume")
    }

    override fun onPause() {
        super.onPause()
        print("onPause")
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(acceleroEventListener)
        print("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        print("onDestroy")
    }

}