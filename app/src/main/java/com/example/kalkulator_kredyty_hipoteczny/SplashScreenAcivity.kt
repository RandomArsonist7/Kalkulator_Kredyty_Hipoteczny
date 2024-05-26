package com.example.kalkulator_kredyty_hipoteczny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.PorterDuff
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast

class SplashScreenAcivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private val splashScreenDuration: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_acivity)

        // Set the color of the ProgressBar

        progressBar = findViewById(R.id.progressBar)
        // Log and Toast onCreate
        Log.d("SplashScreenActivity", "onCreate called")
        Toast.makeText(this, "SplashScreenActivity: onCreate", Toast.LENGTH_SHORT).show()

        progressBar.indeterminateDrawable.setColorFilter(
            resources.getColor(R.color.spacecadet, null),
            PorterDuff.Mode.SRC_IN
        )
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashScreenDuration)
    }
    private fun startProgressBarAnimation() {
        val progressMax = 100
        val progressTime = splashScreenDuration / progressMax
        var currentProgress = 0

        // Increment the progress periodically
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                progressBar.progress = currentProgress
                currentProgress++
                if (currentProgress <= progressMax) {
                    handler.postDelayed(this, progressTime)
                }
            }
        }
        handler.postDelayed(runnable, progressTime)
    }


    override fun onStart() {
        super.onStart()
        Log.d("SplashScreenActivity", "onStart called")
        Toast.makeText(this, "SplashScreenActivity: onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashScreenActivity", "onResume called")
        Toast.makeText(this, "SplashScreenActivity: onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashScreenActivity", "onPause called")
        Toast.makeText(this, "SplashScreenActivity: onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashScreenActivity", "onStop called")
        Toast.makeText(this, "SplashScreenActivity: onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashScreenActivity", "onDestroy called")
        Toast.makeText(this, "SplashScreenActivity: onDestroy", Toast.LENGTH_SHORT).show()
    }


}

