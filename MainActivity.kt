package com.somnopulse.watch

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : Activity() {

    private lateinit var statusText: TextView
    private lateinit var toggleButton: Button
    private lateinit var testPulseButton: Button
    private var isMonitoring = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Simple Wear OS programmatic layout
        val layout = android.widget.LinearLayout(this).apply {
            orientation = android.widget.LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setPadding(32, 32, 32, 32)
            setBackgroundColor(android.graphics.Color.BLACK)
        }

        statusText = TextView(this).apply {
            text = "SomnoPulse Ready"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 14f
            gravity = android.view.Gravity.CENTER
            setPadding(0, 0, 0, 16)
        }

        toggleButton = Button(this).apply {
            text = "Start Sleep Guard"
            setOnClickListener {
                if (isMonitoring) stopService() else checkPermissionsAndStart()
            }
        }

        testPulseButton = Button(this).apply {
            text = "Test Haptic Pulse"
            setOnClickListener {
                val serviceIntent = Intent(this@MainActivity, SnoreDetectorService::class.java)
                startService(serviceIntent)
            }
        }

        layout.addView(statusText)
        layout.addView(toggleButton)
        layout.addView(testPulseButton)
        setContentView(layout)
    }

    private fun checkPermissionsAndStart() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 101)
        } else {
            startService()
        }
    }

    private fun startService() {
        val intent = Intent(this, SnoreDetectorService::class.java)
        ContextCompat.startForegroundService(this, intent)
        isMonitoring = true
        statusText.text = "Guard Active (Listening)"
        statusText.setTextColor(android.graphics.Color.parseColor("#38BDF8"))
        toggleButton.text = "Stop Sleep Guard"
    }

    private fun stopService() {
        val intent = Intent(this, SnoreDetectorService::class.java)
        stopService(intent)
        isMonitoring = false
        statusText.text = "Guard Stopped"
        statusText.setTextColor(android.graphics.Color.WHITE)
        toggleButton.text = "Start Sleep Guard"
    }
}
