package com.example.eventm

import com.orhanobut.hawk.Hawk


const val TOKEN_KEY = "TOKEN_KEY"
const val SESSION_KEY = "SESSION_KEY"
const val ID_key="ID_KEY"

fun saveToken(token : String){
    Hawk.put(TOKEN_KEY, token)
}

fun getToken() : String{
    return Hawk.get(TOKEN_KEY, "no_token")
}

fun setUserLogin(isLogin : Boolean){
    Hawk.put(SESSION_KEY, isLogin)
}

fun isUserLogin() : Boolean {
    return Hawk.get(SESSION_KEY, false)
}

fun logoutUser(){
    Hawk.delete(SESSION_KEY)
}

fun saveIdUserProfil(Id:Int){
Hawk.put(ID_key,Id)
}

fun getID():Int{
    return Hawk.get(ID_key,0)
}
