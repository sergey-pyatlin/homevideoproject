package com.testapp.homevideoproject

import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.TransferListener
import com.google.android.exoplayer2.util.Util


class ExoPlayerExt {
    lateinit private var viewSimpleExoPlayerView : SimpleExoPlayerView
    private lateinit var trackSelector: DefaultTrackSelector
    private lateinit var player: SimpleExoPlayer
    private var shouldAutoPlay: Boolean = true
    private lateinit var context : Context

    constructor(viewExoPlayer: SimpleExoPlayerView, cnxt: Context){
        viewSimpleExoPlayerView = viewExoPlayer
        context = cnxt
    }

    public fun initPlayer(){
        val bandwidthMeter = DefaultBandwidthMeter()
        val extractorsFactory = DefaultExtractorsFactory()
        viewSimpleExoPlayerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL)
        //TODO: change hack const
        viewSimpleExoPlayerView.minimumHeight=700
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val mediaDataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "mediaPlayerSample"), bandwidthMeter as TransferListener<in DataSource>)
        val mediaSource = ExtractorMediaSource(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"),
                mediaDataSourceFactory, extractorsFactory, null, null)

        //viewSimpleExoPlayerView?.requestFocus()
        trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        player = ExoPlayerFactory.newSimpleInstance(context, trackSelector)

        viewSimpleExoPlayerView?.player = player
        player.playWhenReady = shouldAutoPlay
        player.prepare(mediaSource)
    }

    fun releasePlayerX() {
        player.release()
        shouldAutoPlay = player.playWhenReady
    }

}


