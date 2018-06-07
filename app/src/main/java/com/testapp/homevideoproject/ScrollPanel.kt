package com.testapp.homevideoproject

import android.R.attr.timePickerStyle
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scroll_panel.*
import android.widget.*
import android.widget.Toast
import android.graphics.Point
import android.R.attr.x
import android.app.ActionBar
import android.graphics.Color
import android.media.MediaPlayer
import android.net.Uri
import android.support.annotation.ColorRes
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*


class ScrollPanel : AppCompatActivity() {

    //lateinit var mygestureDetector: GestureDetector
    lateinit var switcherContainer: LinearContainer
    lateinit var linearSwitcherT: LinearSwitcher
    lateinit var viewView: VideoView

    var m_Width = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)

        //mygestureDetector = GestureDetector(this@ScrollPanel, MyGestureDetector())

        ic_light_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "Жопа - свет в доме!", Toast.LENGTH_SHORT).show()
            ic_light_detector.setColorFilter(R.color.material_grey_900)
        }
        ic_moving_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "ДВИЖЕНИЕ!!!", Toast.LENGTH_SHORT).show()
        }
        ic_water_leak_detector.setOnClickListener {
            Toast.makeText(this@ScrollPanel, "ПОТОП!!!", Toast.LENGTH_SHORT).show()
        }

        val display = getWindowManager().getDefaultDisplay()
        val size = Point()
        display.getSize(size)
        val width = size.x
        val height = size.y

        linearSwitcherT = LinearSwitcher(this@ScrollPanel, scroll, width)
        linearSwitcherT.InitContainers()
        linearLayout1.addView(linearSwitcherT)


        var videoView = VideoView(this)
        videoView.setLayoutParams(FrameLayout.LayoutParams(1000,700))
        linearLayout1.addView(videoView)

        var stringPath: String = "http://www.ebookfrenzy.com/android_book/movie.mp4"
        val mediaController: MediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)

        val uriString: Uri = Uri.parse(stringPath)
        videoView.setVideoURI(uriString)
        videoView.setMediaController(mediaController)

        videoView.setOnPreparedListener(MediaPlayer.OnPreparedListener(function = {
            videoView.start()
        }))




    }
}
