package com.devaloteam.valorantmanager

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.devaloteam.valorantmanager.Login.WebViewActivity

class MainActivity : AppCompatActivity() {
    private var iv: ImageView? = null
    private var iv2: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        iv = findViewById<View>(R.id.IntroApp) as ImageView
        iv2 = findViewById<View>(R.id.IntroApp2) as ImageView



        val myanim = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val myanim2 = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        iv!!.startAnimation(myanim)
        Handler().postDelayed({
            iv2!!.startAnimation(myanim2)
        }, 2000)

        Handler().postDelayed({
            super.onBackPressed()
            val  intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, 2350)

    }
}