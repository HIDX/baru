package com.example.evntm.Common

import com.example.myapp.Remote.IMyAPI
import com.example.myapp.Remote.RetrofitClient

object Common {
    val BASE_URL="http://104.248.149.236/user/public/"  //domain sebelum endpoint
    val api:IMyAPI
    get()=RetrofitClient.getclient(BASE_URL).create(IMyAPI::class.java)
}

object Common2 {
    val BASE_URL_g="http://104.248.149.236/general/public/"
    val api:IMyAPI
        get()=RetrofitClient.getclient(BASE_URL_g).create(IMyAPI::class.java)
}


