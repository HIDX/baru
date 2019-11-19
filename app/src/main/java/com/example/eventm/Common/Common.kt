package com.example.evntm.Common

import com.example.eventm.BuildConfig
import com.example.myapp.Remote.IMyAPI
import com.example.myapp.Remote.RetrofitClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object Common {
    val BASE_URL="http://104.248.149.236/"  //domain sebelum endpoint
    val api:IMyAPI
    get()=RetrofitClient.getclient(BASE_URL).create(IMyAPI::class.java)
}