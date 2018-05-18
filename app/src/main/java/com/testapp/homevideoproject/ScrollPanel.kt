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

    //lateinit var mygestureDetector: GestureDetector
    lateinit var switcherContainer: LinearContainer
    lateinit var linearSwitcherT: LinearSwitcher
    lateinit var viewView: VideoView

    var m_Width = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)

        //mygestureDetector = GestureDetector(this@ScrollPanel, MyGestureDetector())

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

        val display = getWindowManager().getDefaultDisplay()
        val size = Point()
        display.getSize(size)
        val width = size.x
        val height = size.y

        linearSwitcherT = LinearSwitcher(this@ScrollPanel, scroll, width)
        linearSwitcherT.InitContainers()
        linearLayout1.addView(linearSwitcherT)


        viewView = VideoView(this)

    }
}
