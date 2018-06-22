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
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlaybackControlView
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.TransferListener
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.currentTimeMillis


class ScrollPanel : AppCompatActivity(), PlaybackControlView.VisibilityListener{
    //lateinit var mygestureDetector: GestureDetector
    lateinit var switcherContainer: LinearContainer
    lateinit var linearSwitcherT: LinearSwitcher
    lateinit var sSimpleExoPlayerView:  SimpleExoPlayerView
    //lateinit var videoView2:  VideoViewExt
    lateinit private var testPlayer: ExoPlayerExt


    private lateinit var trackSelector: DefaultTrackSelector
    //private lateinit var player: SimpleExoPlayer
    private var shouldAutoPlay: Boolean = true


    var m_Width = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_panel)

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

        //Переключатель
        linearSwitcherT = LinearSwitcher(this@ScrollPanel, scroll, width)
        linearSwitcherT.InitContainers()
        linearLayout1.addView(linearSwitcherT)

        //Проигрыватель
        sSimpleExoPlayerView = SimpleExoPlayerView(this@ScrollPanel)
        linearLayout1.addView(sSimpleExoPlayerView)
        sSimpleExoPlayerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL)
        sSimpleExoPlayerView.setControllerVisibilityListener(this)


        testPlayer = ExoPlayerExt (sSimpleExoPlayerView, this@ScrollPanel)
        testPlayer.initPlayer()
    }

    @Override
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            testPlayer.releasePlayerX()
        }
    }

    override fun onVisibilityChange(visibility: Int) {
        if(visibility == View.GONE) {
            sSimpleExoPlayerView.showController()
        }
    }
}




