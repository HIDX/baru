package com.example.eventm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background = object : Thread(){
            override fun run() {
                try {
                    Thread.sleep(5000)
                    val intent= Intent(baseContext, IntroActivity::class.java)
                    startActivity(intent)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }

        background.start()
    }
}