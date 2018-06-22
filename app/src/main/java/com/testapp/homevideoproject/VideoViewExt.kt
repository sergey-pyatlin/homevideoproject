package com.testapp.homevideoproject

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.animation.ScaleAnimation
import android.widget.MediaController
import android.widget.VideoView
import android.view.TextureView

class VideoViewExt : VideoView{

    private var mController:MediaController
    init{
        mController = MediaController(this.context)
    }

    constructor(context: Context):super(context){
    }


    fun initMController( stringPath: String){
        //setZOrderOnTop(true)
        val uriString: Uri = Uri.parse(stringPath)
        mController.setAnchorView(this)
        mController.setMediaPlayer(this)
        setVideoURI(uriString)
        setMediaController(mController)

        setOnPreparedListener(MediaPlayer.OnPreparedListener(function = {
            start()
        }))
    }

    fun releasePlayer(){
        mController.hide()
        stopPlayback()
    }
}