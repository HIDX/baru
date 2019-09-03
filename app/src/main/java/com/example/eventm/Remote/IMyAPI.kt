package com.example.myapp.Remote

import android.content.ClipData
import com.example.myapp.Model.APIresponse
import com.example.myapp.Model.IntroS
import retrofit2.Call
import retrofit2.http.*

interface IMyAPI {
    @FormUrlEncoded
    @POST ("register")
    fun registerUser(@Field("name")username:String,@Field("numberPhone")numberPhone:String,@Field("email")email: String,@Field("password")password: String):Call<APIresponse>


    @FormUrlEncoded
    @POST ("auth/login")
    fun loginUser(@Field("user_email")email: String,@Field("user_password")password: String):Call<APIresponse>

    @GET("splash")
    fun getSplah () :Call<IntroS>


}