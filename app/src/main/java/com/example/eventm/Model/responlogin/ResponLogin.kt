package com.example.eventm.Model.responlogin

data class ResponLogin(
    val Data: Data,
    val Error: Boolean,
    val Message: String,
    val StatusCode: Int,
    val Token: String
)