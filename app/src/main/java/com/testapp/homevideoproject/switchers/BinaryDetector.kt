package com.testapp.homevideoproject.switchers

/**
 * Created by sergey.pyatlin on 27.12.2017.
 */
class BinarySwitcher:Switcher(){
    private var byCurrentState: Byte = 0
    private var bTrigger:Byte =0
    private var bIsInitializedBynarySwitcher: Boolean = false

    public fun SetCurrentValueOfSwitcher(byValue : Byte){
        byCurrentState = byValue
    }

    public fun SetValueOfTrigger(byTrigger : Byte){
        byCurrentState = byTrigger
        bIsInitializedBynarySwitcher == true
    }

    public fun CheckAlarmValue():AlarmSwitcherState{
        if (bIsInitializedBynarySwitcher == false){
            return AlarmSwitcherState.NOT_INITIALIZED
        } else
            if (byCurrentState == bTrigger) {
                bSetAlarmState(AlarmSwitcherState.ALARM_SWITCHER)
                return bReturnAlarmState()
            }
        return AlarmSwitcherState.NOT_INITIALIZED
    }
}