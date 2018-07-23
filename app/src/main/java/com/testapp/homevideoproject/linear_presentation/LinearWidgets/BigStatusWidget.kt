package com.testapp.homevideoproject.linear_presentation.LinearWidgets

import android.content.Context
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.testapp.homevideoproject.R

class BigStatusWidget: LinearLayout {
    constructor(ctx: Context, vParent: View) : super(ctx){
        vParentView = vParent
        contextSwitcher = getContext()
        cont = ctx
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
    }

    private var vParentView:View
    private var cont: Context
    private var contextSwitcher: Context

    fun InitLine() {
        val imageView = ImageView(contextSwitcher)
        imageView.setImageResource(R.drawable.ic_lockicon)
        imageView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 3f)

        val dataStatus = TextView(contextSwitcher)
        dataStatus.text = "Test Name"
        dataStatus.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35f)
        dataStatus.setTypeface(Typeface.SANS_SERIF)
        dataStatus.setGravity(Gravity.CENTER_VERTICAL)
        dataStatus.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f)

        addView(imageView)
        addView(dataStatus)
    }

    override fun onTouchEvent(ev: MotionEvent):Boolean {
        println(">>> Motion Event - $ev")
        return false;
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        var t = ev.getAction()
        println(">>> onInterceptTouchEvent: Motion Event - $t")

        when (ev.getAction()){
            MotionEvent.ACTION_DOWN -> {
                println(">>> Item Down - Test")
                return true
            }
        }
        return false
    }





}