package com.example.eventm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evntm.Common.Common
import com.example.myapp.Model.APIresponse
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
        txt_register.setOnClickListener { startActivity(Intent(this@LoginActivity,RegisterActivity::class.java)) } // untuk pindah ke hal regis
        txt_forget_password.setOnClickListener { startActivity(Intent(this@LoginActivity,ForgetPasswordActivity::class.java)) }
        btn_login.setOnClickListener {
            authenticateUser(email_login.text.toString(),password_login.text.toString()) // memaggil fungsi yg sudah dibuat

            //Toast.makeText(this, email_login.text.toString()+password_login.text.toString(), Toast.LENGTH_LONG).show() //untuk menapilkan id and pw
        }

    }
    private fun authenticateUser(email: String, password: String) {

        mService.loginUser(email,password)
            .enqueue(object : Callback<APIresponse> {
                override fun onFailure(call: Call<APIresponse>, t: Throwable) {
                    Log.e("errornya tuh disini", t!!.message.toString())
                    Toast.makeText(this@LoginActivity,t!!.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<APIresponse>, response: Response<APIresponse>) {
                    Log.e("responsenya ", response.body().toString())
                    if (response!!.body()!!.StatusCode == 400){
                        Log.i("respone error", response!!.body().toString())
                        Toast.makeText(this@LoginActivity,response.body()!!.Error, Toast.LENGTH_LONG).show()
                    }
                    else {
                        Log.i("respone tidak error", response!!.body().toString())
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)// untuk pindah ke main activity nya
                        startActivity(intent)

                    }
                }
            })

    }
}

