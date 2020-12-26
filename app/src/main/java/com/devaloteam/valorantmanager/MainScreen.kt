package com.devaloteam.valorantmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toolbar

class MainScreen : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        toolbar = findViewById<View>(R.id.toolbarMAIN) as Toolbar?

        val toolbaranim = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        toolbar!!.startAnimation(toolbaranim)
    }
}