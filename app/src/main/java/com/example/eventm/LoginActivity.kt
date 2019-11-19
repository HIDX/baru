package com.example.eventm

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.eventm.Model.token.TokenNew
import com.example.eventm.Model.responlogin.ResponLogin
import com.example.evntm.Common.Common
import com.example.myapp.Remote.IMyAPI
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class LoginActivity: AppCompatActivity(){

    internal lateinit var mService: IMyAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        mService = Common.api

        //Event
        txt_register.setOnClickListener { startActivity(Intent(this@LoginActivity,RegisterActivity::class.java)) } // untuk pindah ke hal regis
        txt_forget_password.setOnClickListener { startActivity(Intent(this@LoginActivity,ForgetPasswordActivity::class.java)) }
        btn_login.setOnClickListener {
            if(isEmailValid(email_login.text.toString())){
                authenticateUser(email_login.text.toString(),password_login.text.toString())
            } else{
                Toast.makeText(this, "email atau password salah", Toast.LENGTH_SHORT).show()
            }

            //Toast.makeText(this, email_login.text.toString()+password_login.text.toString(), Toast.LENGTH_LONG).show() //untuk menapilkan id and pw
        }

    }
    //method supaya tidak masuk ke login lagi dan disimpan data nya dan langunsung pindah ke halaman MainActivity
    override fun onStart() {
        super.onStart()
        if (isUserLogin()) {
            val mainActivity = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
        mService.getToken()
            .enqueue(object :Callback<TokenNew>{
                override fun onFailure(call: Call<TokenNew>, t: Throwable) {
                    Log.e("errornya tuh disini", t!!.message.toString())
                }

                override fun onResponse(call: Call<TokenNew>, response: Response<TokenNew>) {
                    Log.e("tokennya ", response.body().toString())
                    if (response.isSuccessful){
                        saveToken(response.body()!!.Data.Token)

                    }
                }

            })
    }

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun authenticateUser(email: String, password: String) {



        mService.loginUser(email,password)
            .enqueue(object : Callback<ResponLogin> {
                override fun onFailure(call: Call<ResponLogin>, t: Throwable) {
                    Log.e("errornya tuh disini", t!!.message.toString())
                    Toast.makeText(this@LoginActivity,t!!.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ResponLogin>, response: Response<ResponLogin>) {
                    Log.e("responsenya ", response.body().toString())
                    if (response!!.body()!!.StatusCode == 400){
                        Log.i("respone error", response!!.body().toString())
                        Toast.makeText(this@LoginActivity,response.body()!!.Message, Toast.LENGTH_LONG).show()
                    }
                    else {
                        Log.i("respone tidak error", response!!.body().toString())
                        saveIdUserProfil(response.body()!!.Data.id)
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)// untuk pindah ke main activity nya
                        startActivity(intent)
                        setUserLogin(true)
//                        savePrefsData()
                        finish()
                    }
                }
            })

    }


}

