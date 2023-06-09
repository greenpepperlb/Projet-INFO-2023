package com.example.application2023

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import kotlin.random.Random

class Ball(private val dWidth: Int, private val dHeight: Int, private val radius:Int, private val color:Int): GameObject(Random.nextInt(dWidth/2 -10,dWidth/2 + 10),dHeight/2) {
    private var x:Int = getX()
    private var y:Int = getY()
    private var xVel: Int = Random.nextInt(7,13)
    private var yVel: Int = Random.nextInt(7,13)

    fun getRadius(): Int{
        return radius
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
            reverseVelocity(1)
        }
        if (y - radius < 0){
            reverseVelocity(2)
        }
        if(y + radius > dHeight){
            setY(dHeight/2)
            setX(Random.nextInt(dWidth/2 -10,dWidth/2 + 10))
            x = getX()
            y= getY()
            setXVel(Random.nextInt(7,13))
            setYVel(Random.nextInt(7,13))
        }
    }

    fun getRect(): Rect{
        return Rect(x-radius,y-radius, x+radius, y+radius)
    }

    fun reverseVelocity(i: Int){
        if (i==2){
            yVel *= -1
        }
        else{
            xVel *= -1
        }

    }
}