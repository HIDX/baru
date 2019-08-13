package com.example.myapp.Remote

import android.content.ClipData
import com.example.myapp.Model.APIresponse
import retrofit2.Call
import retrofit2.http.*

interface IMyAPI {
    @FormUrlEncoded
    @POST ("register")
    fun registerUser(@Field("name")name:String,@Field("email")email: String,@Field("password")password: String):Call<APIresponse>


    @FormUrlEncoded
    @POST ("login")
    fun loginUser(@Field("email")email: String,@Field("password")password: String):Call<APIresponse>


}