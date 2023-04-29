package com.example.application2023

import android.content.Context
import android.graphics.Canvas
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import kotlin.math.pow
import kotlin.math.sqrt

class GameView(context: Context, attrs: AttributeSet?, dWidth: Int, dHeight: Int) : View(context, attrs), OnTouchListener{
    private val maxANGLE: Double=80.0
    private var paddle: Paddle = Paddle(200, 20, dWidth, dHeight)
    private var ball: Ball = Ball(dWidth, dHeight, 25, 0)
    //private lateinit var bricks: ArrayList<Brick>

    init{
        setOnTouchListener(this)
       // bricks.add(Brick(150,30,dWidth/2,dHeight/4))
       // bricks.add(Brick(150,30,dWidth/2 +200 ,dHeight/4))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paddle.draw(canvas)
        ball.draw(canvas)
        //for (brick in bricks){
         //   brick.draw(canvas)}
        ball.moveBall()
        checkBallPaddleCollision()
        //checkBallBrickCollision()
        invalidate()
    }

    /*private fun checkBallBrickCollision() {
        val ballRect = ball.getRect()


        for(brick in bricks) {
            val brickRect= brick.getRect()
            if (ballRect.intersect(brickRect)) {
                bricks.remove(brick)
                ball.reverseVelocity(2)
                break
            }
        }

    }*/

    private fun checkBallPaddleCollision() {
        val ballRect = ball.getRect()
        val paddleRect = paddle.getRect()

        if (ballRect.intersect(paddleRect)) {
            ballHitPaddle(ball, paddle)
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

    private fun ballHitPaddle(ball: Ball, paddle: Paddle){
        var paddleCenter:Int = paddle.getX() + paddle.getPaddleWidth()/2
        var distanceFromPaddleCenter = ball.getX() + ball.getRadius() - paddleCenter
        var maxDistanceFromPaddleCenter = (paddle.getPaddleWidth() / 2) + ball.getRadius()



        var hitPercentage = distanceFromPaddleCenter/maxDistanceFromPaddleCenter
        var newAngle = hitPercentage*maxANGLE

        var speed = sqrt(ball.getXVel().toDouble().pow(2.0) + ball.getYVel().toDouble().pow(2.0))

        ball.setYVel(-(speed*kotlin.math.cos(Math.toRadians(newAngle))).toInt())
        ball.setXVel((speed*kotlin.math.sin(Math.toRadians(newAngle))).toInt())
        Log.d("TAG:","xVel ${ball.getXVel()}, yVel ${ball.getYVel()}")
        Log.d("TAG:","dist $distanceFromPaddleCenter, newAngle $newAngle")
    }



}