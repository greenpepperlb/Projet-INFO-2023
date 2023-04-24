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

    fun getRadius(): Int{
        return radius
    }

    fun getX(): Int {
        return x
    }

    fun setX(a: Int) {
        x=a
    }

    fun getY(): Int {
        return y
    }

    fun setY(a: Int) {
        y=a
    }

    fun getXVel(): Int {
        return xVel
    }

    fun setXVel(a: Int) {
        xVel=a
    }

    fun getYVel(): Int {
        return yVel
    }

    fun setYVel(a: Int) {
        yVel=a
    }
    fun draw(canvas: Canvas) {
        val paint= Paint()
        paint.color = Color.parseColor("#FFFFFF")
        canvas.drawCircle(x.toFloat(),y.toFloat(), radius.toFloat(),paint)
    }

    fun moveBall(){
        x+=xVel
        y+=yVel
        if (x - radius <0 || x + radius > dWidth){
            reverseVelocityX()
        }
        if (y - radius < 0 || y + radius > dHeight){
            reverseVelocityY()
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