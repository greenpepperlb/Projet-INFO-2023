package com.example.application2023

import android.graphics.*

class Brick(private val brickWidth: Int, private val brickHeight: Int, private var x: Int, private var y: Int): GameObject(x,y) {
    private var rect: Rect = Rect(x, y, x + brickWidth, y + brickHeight)
    private var paint: Paint = Paint()

    init {
        paint.color = Color.parseColor("#FFFF00")
        paint.style = Paint.Style.FILL
    }
    fun getRect(): Rect {
        return rect
    }

    fun draw(canvas: Canvas) {
        canvas.drawRect(rect, paint)
    }

}