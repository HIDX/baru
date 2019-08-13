package com.example.eventm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evntm.Common.Common
import com.example.myapp.Model.APIresponse
import com.example.myapp.Model.User
import com.example.myapp.Remote.IMyAPI
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity: AppCompatActivity(){

    internal lateinit var mService: IMyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //init service
        mService = Common.api

        //Event
        txt_register.setOnClickListener { startActivity(Intent(this@LoginActivity,RegisterActivity::class.java)) }

        btn_login.setOnClickListener { authenticateUser(email.text.toString(),password.text.toString()) }
        Toast.makeText(this@LoginActivity, authenticateUser(email.text.toString(),password.text.toString()), Toast.LENGTH_LONG).show()

    }
    private fun authenticateUser(email: String, password: String): String {
        lateinit var respon: String

        mService.loginUser(email,password)
            .enqueue(object : Callback<APIresponse> {
                override fun onFailure(call: Call<APIresponse>, t: Throwable) {
                    Log.e("errornya tuh disini", t!!.message.toString())
                    Toast.makeText(this@LoginActivity,t!!.message, Toast.LENGTH_LONG).show()
                            respon = "gagal"
                }

                override fun onResponse(call: Call<APIresponse>, response: Response<APIresponse>) {
                    Log.e("responsenya ", response.body().toString())
                    if (response!!.body()!!.error){
                        Log.i("respone error", response!!.body().toString())
                        Toast.makeText(this@LoginActivity,response.body()!!.error_msg, Toast.LENGTH_LONG).show()
                    }
                    else {
                        Log.i("respone tidak error", response!!.body().toString())
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)// untuk pindah ke main activity nya
                        startActivity(intent)
                        respon = "berhasil"
                    }
                }
            })
        return respon
    }
}

