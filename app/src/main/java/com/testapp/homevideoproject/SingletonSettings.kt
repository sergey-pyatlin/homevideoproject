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
    var byCountSwitcherOnThePage: Byte = 2
    private var mp_IsSitchersInitialized = false

    public fun InitSwitchers(){
        if (mp_IsSitchersInitialized == true) return
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


        var bBynarySwitcherRobot: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherRobot.InitSwitcher("Robot Swither", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherRobot.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherRobot)


        var bBynarySwitcherCamera1: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherCamera1.InitSwitcher("Camera1 Swither", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherCamera1.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherCamera1)

        var bBynarySwitcherCamera2: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherCamera2.InitSwitcher("Camera2 Swither", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherCamera2.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherCamera2)

        var bBynarySwitcherCamera3: BinarySwitcher = BinarySwitcher()
        bBynarySwitcherCamera3.InitSwitcher("Camera3 Swither", EnSwitcherType.BYNARY_SWITCHER)
        bBynarySwitcherCamera3.SetValueOfTrigger(1)
        listSwitchers.add(bBynarySwitcherCamera3)

        mp_IsSitchersInitialized = true
    }

    public fun getCountOfSwitchers():Int{
        return listSwitchers.size
    }

}