package com.example.myapp.Model

import com.google.gson.annotations.SerializedName

//class APIresponse {
//
//    var StatusCode : Int = 0
//    var Error: String? =null
//    var uid:String?=null
//    var error_msg:String?=null
//    var user:User?=null
//}


data class APIresponse(
    val StatusCode : Int,
    val Error : String,
    val Message : String,
    @SerializedName("Data")
    val user : User,
    val Token : String
)
//Intro
data class IntroS(
    val StatusCode: Int,
    val Error: String,
    val Message: String,
    @SerializedName("Data")
    val itemScreen : List<Screen>
)

data class Screen(
    val splash_id :Int,
    val event_code :String,
    val splash_title:String,
    val splash_desc:String,
    val splash_image:String,
    val splash_bg_color:String,
    val create_at: String,
    val updated_at:String,
    val deleted_at:String,
    val Activation:String


)
