package com.anim.circleanim

import android.content.Context
import kotlin.math.roundToInt

object Utils {

    public fun dpToPixel(c: Context, dp:Int):Int {

        return (dp*c.resources.displayMetrics.density).roundToInt()

    }

    public fun PixelTodp(c: Context, pixel:Int):Int {

        return (pixel/c.resources.displayMetrics.density).roundToInt()


    }

    fun getScreenWidth(c:Context) : Int {

        return c.resources.displayMetrics.widthPixels

    }

    fun getScreenHeight(c:Context) : Int {

        return c.resources.displayMetrics.heightPixels

    }
}