package com.testapp.homevideoproject
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scroll_panel.*
import java.util.*

/*
*LinerSwotcher has Containers. Container has LineOfSwithcer. LinerSwither has image and text
 */

class LineOfSwitcher:LinearLayout{
    constructor(ctx: Context, vParent: View) : super(ctx){
        vParentView = vParent
        cont = ctx
        contextSwitcher = getContext()
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, iHeightDP)
        setGravity(Gravity.CENTER_VERTICAL)


    }

    private var idSwitcher: Int = 0
    private var sSwitcherName: String = ""
    private var sSwitcherIconPath: String = ""
    private var vParentView:View
    private var cont: Context
    private var contextSwitcher: Context
    private val iHeightDP: Int = 100


    fun SetDataFormat(sIcon: String, s_settingName: String){
        sSwitcherName = s_settingName
        sSwitcherIconPath = sIcon
    }

    fun InitLine() {
        val scale = context.resources.displayMetrics.density
        var pixels: Int = (iHeightDP * scale + 0.5f).toInt()
        this.setMinimumHeight(pixels)

        val imageView = ImageView(contextSwitcher)
        imageView.setImageResource(R.drawable.ic_lockicon)
        imageView.setMinimumHeight(pixels)
        val lp = LayoutParams(iHeightDP, LayoutParams.WRAP_CONTENT, 1f)
        imageView.setLayoutParams(lp)

        val tvSwitcher = TextView(contextSwitcher)
        tvSwitcher.text = sSwitcherName
        tvSwitcher.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        tvSwitcher.setTypeface(Typeface.SANS_SERIF)
        tvSwitcher.setGravity(Gravity.CENTER_VERTICAL)

        val lp2 = LayoutParams(iHeightDP, LayoutParams.WRAP_CONTENT, 5f)
        tvSwitcher.setLayoutParams(lp2)

        addView(imageView)
        addView(tvSwitcher)

//        setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                if (v!=null) {
//                    var s: ViewParent = v.parent
//                    println(">>> On Click - $sSwitcherName")
//                }
//
//            }
//        })

    }

    override fun onTouchEvent(ev:MotionEvent):Boolean {
        println(">>> Motion Event - $ev")
        return false;
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        var t = ev.getAction()
        println(">>> onInterceptTouchEvent: Motion Event - $t")

        when (ev.getAction()){
            MotionEvent.ACTION_DOWN -> {
                println(">>> Item Down - $sSwitcherName")
                return true
            }
        }
        return false
    }

}