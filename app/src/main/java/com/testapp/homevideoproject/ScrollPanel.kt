package com.testapp.homevideoproject

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_scroll_panel.*
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.widget.*
import com.testapp.homevideoproject.R.layout.carousel_container
import kotlinx.android.synthetic.main.carousel_container.*


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

        var lineOfSwitcher = LineOfSwitcher(this, linearSwitcher)
        lineOfSwitcher.SetDataFormat("","LinerSwitcher1")
        lineOfSwitcher.InitLine()

        var linearSwitcher = scroll.findViewById<LinearLayout>(R.id.linearSwitcher)

        val tvSwitcher = TextView(this)
        tvSwitcher.text = "Nexxt step of my changes - make "
        tvSwitcher.setWidth(600)
        tvSwitcher.setBackgroundColor(Color.BLUE)

        linearSwitcher.addView(lineOfSwitcher)
        linearSwitcher.addView(tvSwitcher)

//        val inflater = this@ScrollPanel.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
 //       val view = inflater.inflate(R.layout.carousel_container, linearSwitcher, false)
 //       linearSwitcher.addView(view)
        //val testLinearLayout: LinearLayout = findViewById(R.id.carousel_container) as LinearLayout

/*        var ltInflater: LayoutInflater = layoutInflater
        var line : LinearLayout = LinearLayout(this@ScrollPanel)

        for (x in 1..10 step 1){
            val item : FrameLayout = ltInflater.inflate(R.layout.carousel_container, line, false) as FrameLayout

            val tvName = item.findViewById<TextView>(R.id.tvName)
            var strS:String = ">>> item #: $x"
            if (x==1)
                tvName.setBackgroundColor(Color.RED)
            if (x==2)
                tvName.setBackgroundColor(Color.YELLOW)
            if (x==3)
                tvName.setBackgroundColor(Color.BLUE)
            tvName.setText(strS)
            line.addView(item)


        }
        linearSwitcher.addView(line)*/
    }
}
