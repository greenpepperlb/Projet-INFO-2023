package com.example.application2023

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

class GameView(context: Context, attrs: AttributeSet?, dWidth: Int, dHeight: Int) : View(context, attrs), OnTouchListener{

    private var paddle: Paddle = Paddle(200, 20, dWidth, dHeight)
    private var ball: Ball = Ball(dWidth, dHeight, 25, 0)

    init{
        setOnTouchListener(this)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paddle.draw(canvas)
        ball.draw(canvas)
        ball.moveBall()
        invalidate()
        //draw other game elements here
    }

    override fun onTouch(p0: View, p1: MotionEvent): Boolean {
        paddle.movePaddle(p1)
        invalidate()
        return true
    }

    fun checkCollision(ball: Ball,paddle: Paddle){

    }



}