package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_qrcode.*


class QrcodeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)
        img_back_qr.setOnClickListener { startActivity(Intent(this,MainActivity::class.java))}
    }
}
