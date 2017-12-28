package com.testapp.homevideoproject

import com.testapp.homevideoproject.switchers.BinarySwitcher
import com.testapp.homevideoproject.switchers.EnSwitcherType

/**
 * Created by sergey.pyatlin on 06.12.2017.
 */
public class SingletonSettings private constructor(){
    init {println(">>> This ($this) is a singleton")}

    private object Holder {val INSTANCE = SingletonSettings()}

    companion object {
        val instance: SingletonSettings by lazy {Holder.INSTANCE}
    }

    var b:String? = "OpaЖопа"
    var listSwitchers: MutableList<BinarySwitcher> = mutableListOf()
    var byCountSwitcherOnThePage: Byte = 3

    public fun InitSwitchers(){
        var bBynarySwitcher: BinarySwitcher = BinarySwitcher()
        bBynarySwitcher.InitSwitcher("Action Switcher", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcher.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcher)

        var bBynarySwitcherWater: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherWater.InitSwitcher("Water Switcher", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherWater.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherWater)

        var bBynarySwitcherLight: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherLight.InitSwitcher("Light Switcher", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherLight.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherLight)

        var bBynarySwitcherSauna: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherSauna.InitSwitcher("Sauna Switcher", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherSauna.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherSauna)
    }

    public fun getCountOfSwitchers():Int{
        return listSwitchers.size
    }

}