package com.testapp.homevideoproject

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_scroll_panel.*
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.*
import com.testapp.homevideoproject.R.layout.carousel_container
import com.testapp.homevideoproject.detectors.BinaryDetector
import kotlinx.android.synthetic.main.carousel_container.*
import android.widget.Toast
import android.view.GestureDetector
import com.testapp.homevideoproject.R.id.linearSwitcher
import android.text.method.Touch.onTouchEvent
import android.view.ViewTreeObserver.OnScrollChangedListener
import java.lang.Thread.sleep


class ScrollPanel : AppCompatActivity() {

    lateinit var mygestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)

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

        var linearSwitcher = scroll.findViewById<LinearLayout>(R.id.linearSwitcher)

        var sSingletonSettings = SingletonSettings.instance
        for (item in sSingletonSettings.listDetectors) {
            var lineOfSwitcher = LineOfSwitcher(this, linearSwitcher)
            lineOfSwitcher.SetDataFormat("", item.getDetectorName())
            lineOfSwitcher.InitLine()
            linearSwitcher.addView(lineOfSwitcher)
        }
        linearSwitcher.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                var r = 0
            }
        });

        linearSwitcher.setOnTouchListener(touchListener)

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

            var tempX = linearSwitcher.x
            linearSwitcher.x = tempX - diffX
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
    }
}
