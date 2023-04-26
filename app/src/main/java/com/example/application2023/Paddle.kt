package com.example.application2023

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.MotionEvent


class Paddle(private var paddleWidth: Int, private val paddleHeight: Int, private val dWidth: Int, private val dHeight: Int): GameObject((dWidth - paddleWidth) / 2, dHeight - (paddleHeight * 2) - 300) {
    private var x: Int = getX()
    private var y: Int = getY()

    fun getPaddleWidth(): Int {
        return paddleWidth
    }

    fun draw(canvas: Canvas) {
        val paint= Paint()
        paint.color = Color.parseColor("#00FF00")
        canvas.drawRect(x.toFloat(), y.toFloat(), (x +paddleWidth ).toFloat(), (y + paddleHeight).toFloat(), paint)
    }

    fun movePaddle(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                x = event.x.toInt() - (paddleWidth / 2)
                if (x < 0) {
                    x = 0
                }
                if (x + paddleWidth > dWidth) {
                    x = dWidth - paddleWidth
                }
            }
        }
    }

    fun getRect(): Rect {
        return Rect(x, y, x + paddleWidth, y + paddleHeight)
    }


}
