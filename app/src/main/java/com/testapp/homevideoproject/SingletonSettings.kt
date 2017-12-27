package com.testapp.homevideoproject

import com.testapp.homevideoproject.detectors.BinaryDetector
import com.testapp.homevideoproject.detectors.EnDetectorType

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
    var listDetectors: MutableList<BinaryDetector> = mutableListOf()

    public fun InitDetectors(){
        var bBynaryDetector: BinaryDetector = BinaryDetector()
        bBynaryDetector.InitDetector("Action Detector", EnDetectorType.BYNARY_DETECTOR)
        bBynaryDetector.SetValueOfTrigger(1)
        listDetectors.add(bBynaryDetector)

        var bBynaryDetectorWater: BinaryDetector = BinaryDetector()
        bBynaryDetectorWater.InitDetector("Water Detector", EnDetectorType.BYNARY_DETECTOR)
        bBynaryDetectorWater.SetValueOfTrigger(1)
        listDetectors.add(bBynaryDetectorWater)

        var bBynaryDetectorLight: BinaryDetector = BinaryDetector()
        bBynaryDetectorLight.InitDetector("Light Detector", EnDetectorType.BYNARY_DETECTOR)
        bBynaryDetectorLight.SetValueOfTrigger(1)
        listDetectors.add(bBynaryDetectorLight)
    }

}