package com.example.myapp.Remote

import com.example.eventm.BuildConfig
import com.example.eventm.getToken
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        .addInterceptor(object: Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder()
                    .addHeader("apptoken", "Tra-1007")
                    .addHeader("securitykey", "8448")
                    .addHeader("token", getToken())
                    .build()
                return chain.proceed(request)
            }

        })
        .build()
    private var retrofit:Retrofit?=null
    fun getclient(baseUrl:String):Retrofit{
        if (retrofit==null)
        {
            retrofit= Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }
}
