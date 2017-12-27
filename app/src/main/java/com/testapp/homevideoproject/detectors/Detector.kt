package com.testapp.homevideoproject.detectors

/**
 * Created by sergey.pyatlin on 27.12.2017.
 */

enum class EnDetectorType{
    UNKNOWN_DETECTOR,
    BYNARY_DETECTOR,
    RANGE_DETECTOR
}
enum class ActivityDetectorState{
    ENABLED_DETECTOR,
    DISABLED_DETECTOR,
}
enum class AlarmDetectorState{
    NOT_INITIALIZED,
    NORMAL_DETECTOR,
    ALARM_DETECTOR
}
open class Detector {
    private var enCurrentActivityState: ActivityDetectorState = ActivityDetectorState.DISABLED_DETECTOR
    private var sDetectorName:String=""
    private var bInitializedState:Boolean=false
    private var enAlarmState: AlarmDetectorState = AlarmDetectorState.NORMAL_DETECTOR

    private var byTypeDetector: EnDetectorType = EnDetectorType.UNKNOWN_DETECTOR

    public fun InitDetector(sName:String, enType: EnDetectorType){
        sDetectorName = sName
        byTypeDetector = enType
        bInitializedState = true
    }

    public fun bReturnAlarmState():AlarmDetectorState{
        if (bInitializedState == false)
            return AlarmDetectorState.NOT_INITIALIZED
        else return enAlarmState
    }
    public fun bSetAlarmState(enState: AlarmDetectorState){
        enAlarmState = enState
    }

    public fun getDetectorName():String{
        return sDetectorName
    }
}