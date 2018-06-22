package com.testapp.homevideoproject

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.testapp.homevideoproject.switchers.BinarySwitcher

/**
 * Created by sergey.pyatlin on 28.12.2017.
 * LinerSwotcher has Containers. Container has LineOfSwithcer. LinerfSwither has image and text
 */
class LinearContainer: LinearLayout {
    constructor(ctx: Context, vParent: View, vID: Int, iWidth: Int) : super(ctx){
        m_vParentView = vParent
        m_cont = ctx
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        orientation= VERTICAL
        if (vID==2) setBackgroundColor(Color.RED)
        setGravity(Gravity.CENTER_VERTICAL)
       // minimumWidth = iWidth-50
        m_iWidth = iWidth
        m_iIDPage = vID
        if (m_iIDPage>1) this.x = ((iWidth * (m_iIDPage-1))).toFloat()
        x = x + 1 - 1
    }
    private var m_vParentView:View
    private var m_cont: Context
    private var m_iIDPage: Int = 0
    private var m_iWidth: Int = 0

    public fun InitSwitchers(): Byte {
        minimumWidth = 1
        var sSingletonSettings = SingletonSettings.instance
        if (m_iIDPage==0) return 0

        var sSettingsSingleton = SingletonSettings.instance
        var countSwitchers = sSettingsSingleton.getCountOfSwitchers()
        var countSwitchersOnThePage = sSettingsSingleton.byCountSwitcherOnThePage
        var temp: Double = countSwitchers.div(countSwitchersOnThePage.toDouble())
        var countPagesSwitchers: Int = Math.ceil(temp).toInt()

        var beginSwitcherOnPage = countSwitchersOnThePage*m_iIDPage - (countSwitchersOnThePage -1)
        var endPageCount = countSwitchersOnThePage*m_iIDPage
        var endSwitcherOnPage = if (endPageCount>countSwitchers) countSwitchers else endPageCount


        for (item in beginSwitcherOnPage..endSwitcherOnPage step 1) {
            var switcherItem: BinarySwitcher = sSettingsSingleton.listSwitchers[item-1]
            var lineOfSwitcher = LineOfSwitcher(m_cont, this)
            lineOfSwitcher.SetDataFormat("", switcherItem.getSwitcherName())
            lineOfSwitcher.InitLine()
            addView(lineOfSwitcher)
        }

        return 1
    }
}