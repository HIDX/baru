package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.eventm.Model.register.Register
import com.example.evntm.Common.Common

import com.example.myapp.Model.APIresponse
import com.example.myapp.Remote.IMyAPI
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    internal lateinit var mRegister: IMyAPI

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegister=Common.api
        txt_login.setOnClickListener {
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
            finish()
        } // pergi ke hal login

        btn_register.setOnClickListener {
            if (isRegisterValid(email_sign_up.text.toString()))
            {
                createNewUserRegister(
                    name_sign_up.text.toString(),
                    email_sign_up.text.toString(),
                    password_sign_up.text.toString(),
                    phone_number_sign_up.text.toString()
                    ) // membuat new user

            }else {
                Toast.makeText(this, "isi dengar benar", Toast.LENGTH_SHORT).show()
                /*startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))*/
            }
        }
    }

    fun isRegisterValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    private fun createNewUserRegister(username:String, email:String, userPassword:String,numberphone:String){


            mRegister.getRegister(username,email,userPassword,numberphone)
            .enqueue(object: Callback<Register> {
                override fun onFailure(call: Call<Register>, t: Throwable) { // fungsi saat server tidak merspon
                    Toast.makeText(this@RegisterActivity, t!!.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Register>, responseLogReg: Response<Register>) { // saat server merespon
                    if(responseLogReg.isSuccessful){
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }/*else{
                        Toast.makeText(this@RegisterActivity, responseLogReg.body()!!.Error, Toast.LENGTH_SHORT).show()
                    }*/
                }

            })
    }
}

