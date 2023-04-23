package com.example.application2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Window
import android.widget.FrameLayout

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val dWidth = displayMetrics.widthPixels
        val dHeight = displayMetrics.heightPixels

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val gameView = GameView(this, attrs = null, dWidth, dHeight)

        val frameLayout = findViewById<FrameLayout>(R.id.gameView)
        frameLayout.addView(gameView)
    }


}