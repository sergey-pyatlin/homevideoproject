package com.testapp.homevideoproject

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_scroll_panel.*

class ScrollPanel : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)


        ic_light_detector.setOnClickListener{
            Toast.makeText(this@ScrollPanel, "Жопа - свет в доме!", Toast.LENGTH_SHORT).show()
            ic_light_detector.setColorFilter(R.color.material_grey_900)
        }
        ic_moving_detector.setOnClickListener{
            Toast.makeText(this@ScrollPanel, "ДВИЖЕНИЕ!!!", Toast.LENGTH_SHORT).show()
        }
        ic_water_leak_detector.setOnClickListener{
            Toast.makeText(this@ScrollPanel, "ПОТОП!!!", Toast.LENGTH_SHORT).show()
        }

        val lineOfSwitcher = LineOfSwitcher(this, linearSwitcher)
        lineOfSwitcher.SetDataFormat("","LinerSwitcher1")
        lineOfSwitcher.InitLine()

        val lineOfSwitcher2 = LineOfSwitcher(this, linearSwitcher)
        lineOfSwitcher2.SetDataFormat("","LinerSwitcher2")
        lineOfSwitcher2.InitLine()

        val tvSwitcher = TextView(this)
        tvSwitcher.text = "Nexxt step of my changes - make "
        tvSwitcher.setWidth(600)
        tvSwitcher.setBackgroundColor(Color.BLUE)
        //linearSwitcher.addView(lineOfSwitcher)
        linearSwitcher.addView(tvSwitcher)
        linearSwitcher.addView(lineOfSwitcher)
    }
}
