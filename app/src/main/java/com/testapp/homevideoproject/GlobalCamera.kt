package com.testapp.homevideoproject

/**
 * Created by sergey.pyatlin on 06.12.2017.
 */

enum class CameraStatus{
    TURNED_OFF, ERROR, PLAYING
}
class GlobalCamera (public var sCameraName: String, public var iCameraID: Byte, public var enCameraStatus: CameraStatus) {
    init {
        var sCameraName = ""
        var iCameraID = 0
        var enCameraStatus = CameraStatus.TURNED_OFF
    }
}