package com.anim.circleanim

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.content.ContextCompat

class MyAnim : View {

    var centerX = 0f
    var centerY = 0f
    var rectF:RectF?=null
    var radius = 100f

    var myAnim:ValueAnimator?=null

    var c:Context?=null

    var sweepAngle = 0f

    var paint:Paint?=null

    var startAngle = 0f

    var path:Path?=null

    var canvas:Canvas?=null

    var drawBmp:Bitmap?=null

    var prevSweep=0f

    var prevRValue = 0f

    var rotateAnim:ValueAnimator?=null

    var m:Matrix?=null

    var rValue = 0f

    var t:TypedArray?=null

    var startColor:Int=0
    var secondColor:Int=0
    var thirdColor:Int=0
    var fourthColor:Int=0

    var isFull:Boolean = true
    var isRotate:Boolean = true
    var progressBackground:Int=0
    var duration = 0



    constructor(c:Context) : super(c) {

        this.c = c

    }

    var f:Boolean=false

    var isProgress:Boolean = false

    constructor(c:Context , a:AttributeSet) : super(c,a) {

        t = c.obtainStyledAttributes(a,R.styleable.MyAnim)

        startColor = t!!.getColor(R.styleable.MyAnim_startColor,resources.getColor(android.R.color.holo_red_light))

        Log.d(MyAnim::class.java.name, startColor.toString())
        secondColor = t!!.getColor(R.styleable.MyAnim_startColor,c.resources.getColor(android.R.color.holo_red_dark))
        thirdColor = t!!.getColor(R.styleable.MyAnim_startColor,c.resources.getColor(android.R.color.holo_blue_dark))
        fourthColor = t!!.getColor(R.styleable.MyAnim_startColor,c.resources.getColor(android.R.color.holo_orange_dark))
        isFull = t!!.getBoolean(R.styleable.MyAnim_full,true)
        isRotate = t!!.getBoolean(R.styleable.MyAnim_rotate,true)
        progressBackground = t!!.getColor(R.styleable.MyAnim_clrbackground
        ,resources.getColor(android.R.color.darker_gray))

        duration = t!!.getInt(R.styleable.MyAnim_duration,1000)



        this.c = c

        m = Matrix()

        paint = Paint()
        paint!!.isAntiAlias = true
        //paint!!.color = Color.RED
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeCap = Paint.Cap.ROUND
        //paint!!.strokeWidth = 20f

        if (isFull) {

            myAnim = ValueAnimator.ofFloat(0f,360f)

        } else {

            myAnim = ValueAnimator.ofFloat(0f,269f)

        }


        myAnim!!.setDuration(duration.toLong())
        //myAnim!!.repeatMode = ValueAnimator.RESTART
        //myAnim!!.repeatCount = ValueAnimator.INFINITE
        myAnim!!.addUpdateListener {

            isProgress = true

            sweepAngle = it.getAnimatedValue() as Float
            //m!!.postRotate(sweepAngle)

            if (f) {

                paint!!.color = Color.GRAY

            } else {

                if (!f) {

                    if (sweepAngle>=270f && sweepAngle<=360) {

                        paint!!.color = Color.MAGENTA

                    } else if (sweepAngle>=180f && sweepAngle<270f) {

                        paint!!.color = Color.GREEN

                    } else if (sweepAngle>=90f && sweepAngle<180f) {

                        paint!!.color = Color.BLUE

                    } else  {

                        paint!!.color = Color.CYAN

                    }

                }


            }

            if (!isRotate) {

                invalidate()

            }




        }

        rotateAnim = ValueAnimator.ofFloat(0f,360f)
        rotateAnim!!.setDuration(duration.toLong())
        rotateAnim!!.repeatCount = ValueAnimator.INFINITE
        rotateAnim!!.addUpdateListener {

            rValue = it.getAnimatedValue() as Float;

            if (isRotate) {

                invalidate()

            }

        }

    }

    constructor(c:Context , a:AttributeSet , defStyle:Int) : super(c,a,defStyle) {

        this.c = c

    }

    var mWidth = 0f
    var mHeight = 0f

//    override fun onAttachedToWindow() {
//        super.onAttachedToWindow()
//
//        val lp = this.layoutParams as RelativeLayout.LayoutParams
//
//        if (lp.width == -1
//            || lp.width == -2
//            || lp.height == -1
//            || lp.height == -2) {
//
//            mWidth = (parent as View).width * 0.30f
//            mHeight = mWidth
//
//
//            lp.width = mWidth.toInt()
//            lp.height = mHeight.toInt()
//            lp.addRule(RelativeLayout.CENTER_IN_PARENT)
//
//            this.layoutParams = lp
//
//            requestLayout()
//
//        }
//    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        post {

            val lp = this.layoutParams as RelativeLayout.LayoutParams

            if (lp.width == -1
                || lp.width == -2
                || lp.height == -1
                || lp.height == -2) {

                mWidth = w*0.30f
                mHeight = mWidth


                lp.width = mWidth.toInt()
                lp.height = mHeight.toInt()
                lp.addRule(RelativeLayout.CENTER_IN_PARENT)

                this.layoutParams = lp

                requestLayout()

            } else {

                mWidth = w.toFloat()
                mHeight = h.toFloat()
                radius = mWidth*0.30f
                paint!!.strokeWidth = radius*0.40f

            }

            centerX = w/2f
            centerY = h/2f





            drawBmp = Bitmap.createBitmap(w
                ,h
                ,Bitmap.Config.ARGB_8888)

            rectF = RectF(centerX-radius
                ,centerY-radius
                ,centerX+radius
                ,centerY+radius)

            canvas = Canvas(drawBmp!!)
            //canvas!!.drawColor(Color.BLACK)
            canvas!!.setMatrix(m)

            invalidate()


        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (drawBmp!=null) {

            if (!isProgress) {

                canvas.drawBitmap(drawBmp!!, 0f, 0f, null)

            }



        }





        rectF?.let {


            val delta = sweepAngle-prevSweep

            if (isRotate) {

                val rDelta = rValue - prevRValue
                if (rDelta == 0f) {

                    m!!.postRotate(1f,centerX,centerY)

                } else {

                    m!!.postRotate(rDelta,centerX,centerY)

                }

            }


            this.canvas?.drawArc(it, startAngle+prevSweep, delta, false, paint!!)

            prevSweep = sweepAngle
            prevRValue = rValue
        }

        if (rValue == 360f) {

            prevRValue = 0f
        }



        if (drawBmp!=null) {

            canvas.drawBitmap(drawBmp!!, m!! , paint)

        }

        if (isFull) {

            if (sweepAngle == 360f) {

                myAnim!!.cancel()

                prevSweep = 0f
                startAngle = 0f

                f=!f

                myAnim!!.start()
            }

        } else {

            if (sweepAngle == 269f) {

                myAnim!!.cancel()

                prevSweep = 0f
                startAngle = 0f

                f=!f

                myAnim!!.start()
            }

        }





    }


    fun startAnim() {

        myAnim!!.start()

        if (isRotate) {

            rotateAnim!!.start()

        }

    }
}