package com.example.eventm.Model.register

data class Data(
    val created_at: String,
    val event_code: String,
    val id: Int,
    val name: String,
    val role: Int,
    val updated_at: String,
    val user_email: String,
    val user_phone_number: String,
    val user_password:String
)