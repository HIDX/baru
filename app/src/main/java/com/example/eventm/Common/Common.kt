package com.example.evntm.Common

import com.example.myapp.Remote.IMyAPI
import com.example.myapp.Remote.RetrofitClient

object Common {
    val BASE_URL="http://mediataklim.tech/api/"  //domain sebelum endpoint
    val api:IMyAPI
    get()=RetrofitClient.getclient(BASE_URL).create(IMyAPI::class.java)
}