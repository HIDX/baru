package com.example.myapp.Remote

import com.example.eventm.Model.login.DetailUser
import com.example.eventm.Model.token.TokenNew
import com.example.eventm.Model.editProfil.EditProfil
import com.example.eventm.Model.register.Register
import com.example.eventm.Model.responlogin.ResponLogin
import com.example.myapp.Model.APIresponse
import com.example.myapp.Model.IntroS
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface IMyAPI {
   /* @FormUrlEncoded
    @POST ("gateway/public/register")
    fun registerUser(@Field("name")username:String,
                     @Field("user_phone_number")numberPhone:String,
                     @Field("user_email")email: String,
                     @Field("user_password")password: String):Call<APIresponse>*/


    @FormUrlEncoded
    @POST ("gateway/public/member/login")
    fun loginUser(@Field("user_email")email: String,
                  @Field("user_password")password: String):Call<ResponLogin>

    @POST("gateway/public/token")
    fun getToken() : Call<TokenNew>

    @GET("gateway/public/splash")
    fun getSplah () :Call<IntroS>

    @GET("gateway/public/viewuser/{id}")
    fun getUserDetail(@Path("id") id:Int):Call<DetailUser>

    //gunakan part jika da gambar
    //dan header menggunakan multipart
    @Multipart
    @POST("member/public/editprofile/{id}")
    fun getEditProf(
        @Path("id") id: Int,
        @Part("name")name:RequestBody,
        @Part("organisasi")organisasi:RequestBody,
        @Part("job_title")jobTile:RequestBody,
        @Part userImage:MultipartBody.Part,
        @Part("user_email")email:RequestBody,
        @Part("user_phone_number")userPhoneEdit:RequestBody
    ):Call<EditProfil>

    //dan gunakan formurlencoded
    //field digunakan jika tidak ada gambar samsek
    @FormUrlEncoded
   @POST("gateway/public/member/register")
   fun getRegister(
        @Field("name")name:String,
      // @Part("role")role:Int,
        @Field("user_email")userEmail:String,
        @Field("user_password")userPassword:String,
        @Field("user_phone_number")userPhone:String
   ):Call<Register>

}