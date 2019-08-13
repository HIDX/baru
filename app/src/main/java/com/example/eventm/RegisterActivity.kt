package com.example.eventm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.evntm.Common.Common

import com.example.myapp.Model.APIresponse
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            createNewUser(name.text.toString(), email.text.toString(), password.text.toString())
        }
    }

    private fun createNewUser(name:String, email:String, password:String){
        Common.api.registerUser(name,email,password)
            .enqueue(object: Callback<APIresponse> {
                override fun onFailure(call: Call<APIresponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, t!!.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<APIresponse>, responseLogReg: Response<APIresponse>) {
                    if(responseLogReg!!.body()!!.error){
                        Toast.makeText(this@RegisterActivity, responseLogReg.body()!!.error_msg, Toast.LENGTH_SHORT).show()
                    }else{
                        val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }
                }

            })
    }
}
