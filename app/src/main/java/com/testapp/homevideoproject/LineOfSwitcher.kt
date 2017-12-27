package com.testapp.homevideoproject
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_scroll_panel.*

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
    private val iHeightDP: Int = 50

    fun SetDataFormat(sIcon: String, s_settingName: String){
        sSwitcherName = s_settingName
        sSwitcherIconPath = sIcon
    }

    fun InitLine(){
       val scale = context.resources.displayMetrics.density
        var pixels : Int = (iHeightDP * scale + 0.5f).toInt()
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
    }
}