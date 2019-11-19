package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

import android.util.Log
import android.widget.Toast
import com.example.eventm.Model.login.DataX
import com.example.eventm.Model.login.DetailUser
import com.example.evntm.Common.Common
import com.example.myapp.Remote.IMyAPI
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.img_profil_back
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileActivity : AppCompatActivity() {

    lateinit var mDetailUser:IMyAPI

    lateinit var detailUser: DataX

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mDetailUser=Common.api

        img_profil_back.setOnClickListener { startActivity(Intent(this,MainActivity::class.java))}
        //button logout
        btn_logout_user.setOnClickListener{
            // untuk clear data pref yg sudah ada di login
           logoutUser()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }
            //button history // fungsi finish agar saat intent tidak menumpuk
        ll_session_history.setOnClickListener {
            startActivity(Intent(this,session_history_profil::class.java))
            finish()
        }
            //button edit profil
        ll_edit_profil.setOnClickListener {
            startActivity(Intent(this, EditActivity
            ::class.java))

        }
            //buttin change password
        ll_change_password.setOnClickListener {

        }

        DetailUSers()

    }

    override fun onResume() {
        super.onResume()
        DetailUSers()
    }

    fun DetailUSers () {

        mDetailUser.getUserDetail(getID())
            .enqueue(object :Callback<DetailUser>{
                override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                    Log.e("errornya", t!!.message.toString())
                    Toast.makeText(this@ProfileActivity,t!!.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {
                    Log.e("responsenya ", response.body().toString())
                    if(response.isSuccessful){
                        detailUser = response.body()!!.Data[0]// response.body() untuk mengambil data respon yg ada di api
                        setData()
                    }
                }

            })


    }

    fun setData(){// untunk mengeset data di android nya
        nameProf.text = detailUser.name
        jobTitleProf.text=detailUser.job_title
        emailProf.text=detailUser.user_email
        numberPhoneProf.text=detailUser.user_phone_number
        ORgenProf.text=detailUser.organisasi
        Picasso.get().load(detailUser.user_image)
            //.placeholder(R.drawable.background_image_round)
            //.transform(CircleTransform())
            //.error(R.drawable.background_image_round)
            .into(imgUSerProf)
    }


}

