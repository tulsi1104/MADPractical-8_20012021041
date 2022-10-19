package com.example.madpractical_8_20012021041

import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.madpractical_8_20012021041.R

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var alarmimages : ImageView
    lateinit var alarmimages_frameByFrameAnimation : AnimationDrawable
    lateinit var alarmimagesAnimation : Animation
    lateinit var heartimages : ImageView
    lateinit var heart_frameByFrameAnimation : AnimationDrawable
    lateinit var heartAnimation : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alarmimages = findViewById(R.id.alarmImages)
        alarmimages.setBackgroundResource(R.drawable.alarm_image_list)

        heartimages = findViewById(R.id.heartImages)
        heartimages.setBackgroundResource(R.drawable.heart_image_list)

        alarmimages_frameByFrameAnimation = alarmimages.background as AnimationDrawable

        heart_frameByFrameAnimation = heartimages.background as AnimationDrawable

        alarmimagesAnimation = AnimationUtils.loadAnimation(this, R.anim.alarm_animation)
        alarmimagesAnimation.setAnimationListener(this)

        heartAnimation = AnimationUtils.loadAnimation(this, R.anim.heart_animation)
        alarmimagesAnimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if(hasFocus){
            alarmimages_frameByFrameAnimation.start()
            alarmimages.startAnimation(alarmimagesAnimation)

            heart_frameByFrameAnimation.start()
            heartimages.startAnimation(heartAnimation)
        }
    }
    override fun onAnimationStart(p0: Animation?) {
    }

    override fun onAnimationEnd(p0: Animation?) {
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}