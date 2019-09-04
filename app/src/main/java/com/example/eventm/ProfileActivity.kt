package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

import android.content.Context



class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        img_profil_back.setOnClickListener { startActivity(Intent(this,MainActivity::class.java))}
        //button logout
        btn_logout_user.setOnClickListener{
            // untuk clear data pref yg sudah ada di login
            val myPrefs = getSharedPreferences("mypreflogin", Context.MODE_PRIVATE)
            val editor = myPrefs.edit()
            editor.clear()
            editor.commit()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
            //button history // fungsi finish agar saat intent tidak menumpuk
        ll_session_history.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
            //button edit profil
        ll_edit_profil.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
            //buttin change password
        ll_change_password.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }


}

