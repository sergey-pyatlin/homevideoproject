package com.testapp.homevideoproject

import android.content.Context
import android.graphics.Point
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.testapp.homevideoproject.R.id.scroll
import kotlinx.android.synthetic.main.activity_scroll_panel.*


/**
 * Created by sergey.pyatlin on 29.12.2017.
 */
class LinearSwitcher : RelativeLayout {
    val m_Parent: View
    var m_Width: Int
    var m_cContext: Context
    lateinit var mygestureDetector: GestureDetector

    constructor(ctx: Context, parentView: View): super(ctx) {
        m_Parent = parentView
        m_Width = 0
        m_cContext = ctx
        layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        mygestureDetector = GestureDetector(m_cContext, MyGestureDetector())
    }

    public fun InitContainers(){
        //getting a count of pages needed for switchers
        var sSettingsSingleton = SingletonSettings.instance
        var countSwitchers = sSettingsSingleton.getCountOfSwitchers()
        var countSwitchersOnThePage = sSettingsSingleton.byCountSwitcherOnThePage
        var temp: Double = countSwitchers.div(countSwitchersOnThePage.toDouble())
        var countPagesSwitchers: Int = Math.ceil(temp).toInt()


        for (iPage in 1..countPagesSwitchers step 1){
            var linearSwitcherContainer = LinearContainer(m_cContext, this, iPage, m_Width)
            linearSwitcherContainer.InitSwitchers()
            addView(linearSwitcherContainer)
        }

        setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var r = 0
            }
        })

        setOnTouchListener(touchListener)
    }

    var touchListener: View.OnTouchListener = View.OnTouchListener { v, event ->
        // pass the events to the gesture detector
        // a return value of true means the detector is handling it
        // a return value of false means the detector didn't
        // recognize the event
        mygestureDetector.onTouchEvent(event)

    }

    inner class MyGestureDetector : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            println(">>>single tap up")
            return super.onSingleTapUp(e)
        }

        override fun onDown(e: MotionEvent?): Boolean {
            println(">>>on down")
            return super.onDown(e)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            println(">>>onfling $e1 and $e2")
            println(">>>onfling velocity: $velocityX and $velocityY")

            var sE1:String = e1.toString()
            var sE2:String = e2.toString()

            var X1: Float = e1?.getX() as Float
            var X2: Float = e2?.getX() as Float
            var diffX:Float = X1?.minus(X2)

            var Y1: Float = e1?.getY() as Float
            var Y2: Float = e2?.getY() as Float
            var diffY:Float =Y1?.minus(Y2)

            var endc:Int = diffX.toInt()
            println(">>>endc = $endc")

            var tempX = x

            val time1 = System.currentTimeMillis()

            var iCCount = childCount
            var minimumIndex = 0; var iMinData = 0

            if (endc>0) iMinData = m_Width else iMinData = 0 - m_Width

            for (i in 0..iCCount - 1 step 1) {
                var Child: View = getChildAt(i)
                var iCoord: Int = 0
                if (endc>0) {
                    if (Child.x > 0 && Child.x < iMinData) {
                        iMinData = (Child.x).toInt()
                        minimumIndex = i
                    }
                } else{
                    if (Child.x<= 0 && Child.x > iMinData) {
                        iCoord = (Child.x * (-1)).toInt()
                        iMinData = iCoord
                        minimumIndex = i
                    }
                }
            }
            if (endc>0) iMinData else iMinData = iMinData


            while (iMinData>0){
                iMinData = iMinData / 2
                for (i in 0..iCCount - 1 step 1) {
                    var Child: View = getChildAt(i)
                    if (endc>0) {
                        Child.x = Child.x - iMinData
                    }
                    else {
                        Child.x = Child.x + iMinData
                    }
                }
            }

            val time2 = System.currentTimeMillis()
            var timeDiff = time2-time1
            println (">>> time engine: $timeDiff")

            /*   for (x in 1..endc step 1){
                   sleep(10)
                   println(">>>tempX = $tempX, x=$x")
                   linearSwitcher.x = tempX - x
                   linearSwitcher.invalidate()
               }*/
            //linearSwitcher.scrollTo(X2.toInt(), linearSwitcher.y.toInt())
            //handle the values here        return super.onFling(e1, e2, velocityX, velocityY)
            return false
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            println(">>>double  tap ")
            return super.onDoubleTap(e)
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            println(">>>on scroll $distanceX")
            //handle the values here        return super.onScroll(e1, e2, distanceX, distanceY)
            var sE1:String = e1.toString()
            var sE2:String = e2.toString()

            var X1: Float = e1?.getX() as Float
            var X2: Float = e2?.getX() as Float
            var diffX:Float = X1?.minus(X2)

            var Y1: Float = e1?.getY() as Float
            var Y2: Float = e2?.getY() as Float
            var diffY:Float =Y1?.minus(Y2)

            var endc:Int = diffX.toInt()
            println(">>>endc = $endc")


            var iCCount = childCount

            var Child: View = getChildAt(0)
            var tempX = Child.x
            Child.x = tempX - distanceX
            var Child2: View = getChildAt(1)
            var tempX2 = Child2.x
            Child2.x = tempX2 - distanceX
            var xt = Child2.x
            println(">>>PAGE -2: X=$xt")
            //linearSwitcher.x = tempX - diffX
            invalidate()

            return false
        }

        override fun onContextClick(e: MotionEvent?): Boolean {
            return super.onContextClick(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            println(">>>single confirmed")
            return super.onSingleTapConfirmed(e)
        }

        override fun onShowPress(e: MotionEvent?) {
            super.onShowPress(e)
            println(">>>on show press")
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            println(">>>on double tap")
            return super.onDoubleTapEvent(e)
        }

        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
            println(">>>on long press")

        }
    }
}