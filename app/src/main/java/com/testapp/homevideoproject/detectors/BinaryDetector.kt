package com.testapp.homevideoproject.detectors

/**
 * Created by sergey.pyatlin on 27.12.2017.
 */
class BinaryDetector:Detector(){
    private var byCurrentState: Byte = 0
    private var bTrigger:Byte =0
    private var bIsInitializedBynaryDetector: Boolean = false

    public fun SetCurrentValueOfDetector(byValue : Byte){
        byCurrentState = byValue
    }

    public fun SetValueOfTrigger(byTrigger : Byte){
        byCurrentState = byTrigger
        bIsInitializedBynaryDetector == true
    }

    public fun CheckAlarmValue():AlarmDetectorState{
        if (bIsInitializedBynaryDetector == false){
            return AlarmDetectorState.NOT_INITIALIZED
        } else
            if (byCurrentState == bTrigger) {
                bSetAlarmState(AlarmDetectorState.ALARM_DETECTOR)
                return bReturnAlarmState()
            }
        return AlarmDetectorState.NOT_INITIALIZED
    }
}