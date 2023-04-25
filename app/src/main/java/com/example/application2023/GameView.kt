package com.example.application2023

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import kotlin.math.pow
import kotlin.math.sqrt

class GameView(context: Context, attrs: AttributeSet?, dWidth: Int, dHeight: Int) : View(context, attrs), OnTouchListener{
    private val maxANGLE: Double=90.0
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
        checkBallPaddleCollision()
        invalidate()
    }

    private fun checkBallPaddleCollision() {
        val ballRect = ball.getRect()
        val paddleRect = paddle.getRect()

        if (ballRect.intersect(paddleRect)) {
            changeBallDirection(ball, paddle)
        }
    }
    override fun onTouch(p0: View, p1: MotionEvent): Boolean {
        paddle.movePaddle(p1)
        invalidate()
        return true
    }

    private fun changeBallDirection(ball: Ball, paddle: Paddle) {
        /* get the center of the paddle
        val paddleCenterX = paddle.getX() + (paddle.getPaddleWidth() / 2)
        var pos: Int =1
        if (paddle.getX()<=ball.getX()){
            pos = -1
        }
        // calculate the distance between the ball's center and the paddle's center
        val distanceFromPaddleCenter = (ball.getX() + ball.getRadius()) - paddleCenterX

        // calculate the maximum distance from the center that the ball can hit the paddle
        val maxDistanceFromPaddleCenter = (paddle.getPaddleWidth() / 2) + ball.getRadius()

        // calculate the percentage of the maximum distance that the ball hit the paddle
        val hitPercentage = distanceFromPaddleCenter / maxDistanceFromPaddleCenter

        // calculate the new angle of the ball based on the hit percentage
        val newAngle = hitPercentage * maxANGLE

        val speed = sqrt(ball.getXVel().toDouble().pow(2.0) + ball.getYVel().toDouble().pow(2.0))
        // change the direction of the ball
        ball.setYVel(-(speed*kotlin.math.sin(Math.toRadians(newAngle))).toInt())
        ball.setXVel(pos*(speed*kotlin.math.cos(Math.toRadians(newAngle))).toInt()) */
        val paddleCenter:Int = paddle.getX() + paddle.getPaddleWidth()/2
        ball.reverseVelocity(2)
        if (paddleCenter<ball.getX()&&ball.getXVel()<0){
            ball.reverseVelocity(1)
        }
        else if (paddleCenter>=ball.getX()&&ball.getXVel()>0){
            ball.reverseVelocity(1)
        }

    }



}