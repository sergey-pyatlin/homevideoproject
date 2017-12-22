package com.testapp.homevideoproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_scroll_panel.*

/**
 * Created by sergey.pyatlin on 07.12.2017.
 */
public class ScrollSettingsActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?){

        super.onCreate(savedInstanceState)
        startActivity(Intent(this,MainActivity::class.java))

    }
}