package com.example.application2023

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Ball(private val dWidth: Int, private val dHeight: Int, private val radius:Int, private val color:Int) {
    private var x:Int = dWidth/2
    private var y:Int = dHeight/2
    private var xVel: Int = 12
    private var yVel: Int = 10

    fun draw(canvas: Canvas) {
        val paint= Paint()
        paint.color = Color.parseColor("#FFFFFF")
        canvas.drawCircle(x.toFloat(),y.toFloat(), radius.toFloat(),paint)
    }

    fun moveBall(){
        x+=xVel
        y+=yVel
        if (x - radius <0 || x + radius > dWidth){
            xVel *= -1
        }
        if (y - radius < 0 || y + radius > dHeight){
            yVel *= -1
        }
    }

    fun getRect(): Rect{
        return Rect(x-radius,y-radius, x+radius, y+radius)
    }

    fun reverseVelocityY(){
        yVel *= -1
    }
    fun reverseVelocityX(){
        xVel *= -1
    }
}