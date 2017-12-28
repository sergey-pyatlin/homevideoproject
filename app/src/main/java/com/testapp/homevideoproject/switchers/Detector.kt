package com.testapp.homevideoproject.switchers

/**
 * Created by sergey.pyatlin on 27.12.2017.
 */

enum class EnSwitcherType{
    UNKNOWN_SWITCHER,
    BYNARY_SWITCHER,
    RANGE_Switcher
}
enum class ActivitySwitcherState{
    ENABLED_SWITCHER,
    DISABLED_SWITCHER,
}
enum class AlarmSwitcherState{
    NOT_INITIALIZED,
    NORMAL_SWITCHER,
    ALARM_SWITCHER
}
open class Switcher {
    private var enCurrentActivityState: ActivitySwitcherState = ActivitySwitcherState.DISABLED_SWITCHER
    private var sSwitcherName:String=""
    private var bInitializedState:Boolean=false
    private var enAlarmState: AlarmSwitcherState = AlarmSwitcherState.NORMAL_SWITCHER

    private var byTypeSwitcher: EnSwitcherType = EnSwitcherType.UNKNOWN_SWITCHER

    public fun InitSwitcher(sName:String, enType: EnSwitcherType){
        sSwitcherName = sName
        byTypeSwitcher = enType
        bInitializedState = true
    }

    public fun bReturnAlarmState():AlarmSwitcherState{
        if (bInitializedState == false)
            return AlarmSwitcherState.NOT_INITIALIZED
        else return enAlarmState
    }
    public fun bSetAlarmState(enState: AlarmSwitcherState){
        enAlarmState = enState
    }

    public fun getSwitcherName():String{
        return sSwitcherName
    }
}