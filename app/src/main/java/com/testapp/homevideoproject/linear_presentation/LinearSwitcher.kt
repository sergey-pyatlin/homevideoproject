package com.testapp.homevideoproject.linear_presentation

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.testapp.homevideoproject.SingletonSettings


/**
 * Created by sergey.pyatlin on 29.12.2017.
 * An element with container horisontal scrolling
 * LinerSwotchers has Container. Container has LineOfSwithcer. LinerfSwither has image and text
 */
class LinearSwitcher : RelativeLayout {
    val m_Parent: View
    var m_Width: Int
    var m_cContext: Context
    private var mpr_iActiveContainer: Int
    private var mpr_iMaxContainers: Int
    lateinit var mygestureDetector: GestureDetector

    constructor(ctx: Context, parentView: View, iWidth: Int): super(ctx) {
        m_Parent = parentView
        m_Width = iWidth
        m_cContext = ctx
        mpr_iActiveContainer = 0
        mpr_iMaxContainers = 0
        layoutParams = RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        mygestureDetector = GestureDetector(m_cContext, MyGestureDetector())
    }

    public fun InitContainers(){
        //getting a count of pages needed for switchers
        var sSettingsSingleton = SingletonSettings.instance
        var countSwitchers = sSettingsSingleton.getCountOfSwitchers()
        var countSwitchersOnThePage = sSettingsSingleton.byCountSwitcherOnThePage
        var temp: Double = countSwitchers.div(countSwitchersOnThePage.toDouble())
        var countPagesSwitchers: Int = Math.ceil(temp).toInt()
        mpr_iMaxContainers = countPagesSwitchers

        for (iPage in 1..countPagesSwitchers step 1){
            var linearSwitcherContainer = LinearContainer(m_cContext, this, iPage, m_Width)
            linearSwitcherContainer.InitSwitchers()
            addView(linearSwitcherContainer)
        }

        setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var r = 0
                r = r+1
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

            var iCCount = childCount
            var X1: Float = e1?.getX() as Float
            var X2: Float = e2?.getX() as Float
            var diffX:Int = (X1?.minus(X2)).toInt()

            var shiftX: Int = 0
            if (diffX<0 && mpr_iActiveContainer==0) return false
            if (diffX>0 && mpr_iActiveContainer>=(mpr_iMaxContainers-1)) return false

            var tempShift = diffX.toFloat()
            if (diffX<0) {tempShift = (m_Width - (diffX)).toFloat()}
            if (diffX>=0) {tempShift = (m_Width - diffX).toFloat()}

            //take a difference between shifted and remaining distance with reducing *0.5
            while (tempShift>1){
                tempShift = Math.round((tempShift / 2)).toFloat()
                for (i in 0..iCCount - 1 step 1) {
                    var Child: View = getChildAt(i)
                    if (diffX>0) {
                        Child.x = Child.x - tempShift
                    }
                    else {
                        Child.x = Child.x + tempShift
                    }
                }
            }

            //set coordinates in correct position after animation
            var beginX : Float
            if (diffX>0)
                beginX  = ((mpr_iActiveContainer+1)*m_Width*(-1)).toFloat()
            else
                beginX  = ((mpr_iActiveContainer-1)*m_Width*(-1)).toFloat()

            for (i in 0..iCCount - 1 step 1) {
                var Child: View = getChildAt(i)
                if (i==0)
                        Child.x = beginX
                    else
                        Child.x = (beginX + m_Width).toFloat()
                beginX = Child.x
            }
            if (diffX<0) mpr_iActiveContainer-- else mpr_iActiveContainer++

            for (i in 0..iCCount - 1 step 1) {
                var Child: View = getChildAt(i)
                var Il:Float=Child.x
                println (">>> Total X: Numer=$i and X=$Il")
            }

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

            if (endc<0 && mpr_iActiveContainer==0) return false
            if (endc>0 && mpr_iActiveContainer>=(mpr_iMaxContainers-1)) return false



            var iCCount = childCount
            for (i in 0..iCCount - 1 step 1) {
                var Child: View = getChildAt(i)
                Child.x = Child.x - distanceX
            }

            invalidate()
            return false
        }

        override fun onContextClick(e: MotionEvent?): Boolean {
            println(">>>on onContextClick")
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
            println(">>>on long press")
            super.onLongPress(e)
        }
    }
}