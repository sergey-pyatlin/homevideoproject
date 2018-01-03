package com.testapp.homevideoproject

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.MediaController
import android.widget.VideoView
import com.testapp.homevideoproject.CameraStatus.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        println(">>>==============APPLICATION START=======================")
        super.onCreate(savedInstanceState)

       setContentView(R.layout.activity_main)
//        var decorView : View = window.decorView
//        var uiOptions: Int = View.SYSTEM_UI_FLAG_FULLSCREEN
//        window.getDecorView().setSystemUiVisibility(uiOptions)

        val stringPath1: String = "rtsp://v4.cache3.c.youtube.com/CjYLENy73wIaLQlW_ji2apr6AxMYDSANFEIJbXYtZ29vZ2xlSARSBXdhdGNoYOr_86Xm06e5UAw=/0/0/0/video.3gp"
        val stringPath: String = "http://www.ebookfrenzy.com/android_book/movie.mp4"

        val mediaController: MediaController = MediaController(this)
        mediaController.setAnchorView(videoactivity)
        mediaController.setMediaPlayer(videoactivity)
        val uriString: Uri = Uri.parse(stringPath)
        videoactivity.setMediaController(mediaController)

        buttonChange.setOnClickListener (object: View.OnClickListener {
            override fun onClick(p0: View?) {
  //              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //videoactivity.setVideoURI(uriString)
                val activityIntent = Intent(this@MainActivity, ScrollPanel::class.java)
                activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                activityIntent.putExtra("key", 1)
                startActivity(activityIntent)
            }
        })

        videoactivity.setOnPreparedListener(MediaPlayer.OnPreparedListener(function = {
            videoactivity.start()
        }))

 //TODO: modify test code
        var setB = SingletonSettings.instance
        var Beshka = setB.b
        setB.InitSwitchers()

        var obj1 = GlobalCamera("Test1", 1, TURNED_OFF)
        var obj2 = GlobalCamera("Test2", 2, TURNED_OFF)
        var obj3 = GlobalCamera("Test3", 3, TURNED_OFF)

    }

    override fun onResume() {
        super.onResume()
        println(">>>APPLICATION RESUME=======================")
    }
}
