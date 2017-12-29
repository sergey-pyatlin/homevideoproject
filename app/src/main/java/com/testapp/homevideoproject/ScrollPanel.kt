package com.testapp.homevideoproject

import android.R.attr.timePickerStyle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_scroll_panel.*
import android.view.MotionEvent
import android.widget.*
import android.widget.Toast
import android.view.GestureDetector
import android.graphics.Point
import android.R.attr.x
import android.view.Display





class ScrollPanel : AppCompatActivity() {

    lateinit var mygestureDetector: GestureDetector
    lateinit var switcherContainer: LinearContainer
    lateinit var linearSwitcherT: LinearSwitcher

    var m_Width = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)

        linearSwitcherT = LinearSwitcher(this@ScrollPanel, scroll)
        linearSwitcherT.InitContainers()
        linearLayout1.addView(linearSwitcherT)

        mygestureDetector = GestureDetector(this@ScrollPanel, MyGestureDetector())

        ic_light_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "Жопа - свет в доме!", Toast.LENGTH_SHORT).show()
            ic_light_detector.setColorFilter(R.color.material_grey_900)
        }
        ic_moving_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "ДВИЖЕНИЕ!!!", Toast.LENGTH_SHORT).show()
        }
        ic_water_leak_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "ПОТОП!!!", Toast.LENGTH_SHORT).show()
        }

/*
        //linearSwitcher2.InitContainers()

        //find the LinearLayout (basic for carousels)
        var linearSwitcher = scroll.findViewById<RelativeLayout >(R.id.linearSwitcher)

        //getting a count of pages needed for switchers
        var sSettingsSingleton = SingletonSettings.instance
        var countSwitchers = sSettingsSingleton.getCountOfSwitchers()
        var countSwitchersOnThePage = sSettingsSingleton.byCountSwitcherOnThePage
        var temp: Double = countSwitchers.div(countSwitchersOnThePage.toDouble())
        var countPagesSwitchers: Int = Math.ceil(temp).toInt()

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        m_Width = size.x

        //var linearSwitcher2 = LinearSwitcher(this@ScrollPanel, scroll.findViewById<RelativeLayout >(R.id.linearSwitcher), m_Width)

        for (iPage in 1..countPagesSwitchers step 1){
            var linearSwitcherContainer = LinearContainer(this@ScrollPanel, linearSwitcher, iPage, m_Width)
            linearSwitcherContainer.InitSwitchers()
            linearSwitcher.addView(linearSwitcherContainer)
        }

        linearSwitcher.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var r = 0
            }
        });

        linearSwitcher.setOnTouchListener(touchListener)
*/

    }


    var touchListener: View.OnTouchListener = View.OnTouchListener { v, event ->
        // pass the events to the gesture detector
        // a return value of true means the detector is handling it
        // a return value of false means the detector didn't
        // recognize the event
        mygestureDetector.onTouchEvent(event)

    }


    inner class MyGestureDetector : GestureDetector.SimpleOnGestureListener() {
 /*       override fun onSingleTapUp(e: MotionEvent?): Boolean {
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

            var tempX = linearSwitcher.x

            val time1 = System.currentTimeMillis()

            var iCCount = linearSwitcher.childCount
            var minimumIndex = 0; var iMinData = 0

            if (endc>0) iMinData = m_Width else iMinData = 0 - m_Width

            for (i in 0..iCCount - 1 step 1) {
                var Child: View = linearSwitcher.getChildAt(i)
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
                    var Child: View = linearSwitcher.getChildAt(i)
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


            var iCCount = linearSwitcher.childCount

            var Child: View = linearSwitcher.getChildAt(0)
            var tempX = Child.x
            Child.x = tempX - distanceX
            var Child2: View = linearSwitcher.getChildAt(1)
            var tempX2 = Child2.x
            Child2.x = tempX2 - distanceX
            var xt = Child2.x
            println(">>>PAGE -2: X=$xt")
            //linearSwitcher.x = tempX - diffX
            linearSwitcher.invalidate()

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
*/
    }

}
