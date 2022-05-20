package com.example.learningdemoapi.Api

import com.example.learningdemoapi.InformationItem
import retrofit2.Call
import retrofit2.http.GET

interface EndUrlInterface {

  //  @GET("register")
   // @GET("api/users?page=2")
    //@GET("api/users/2")

    //@GET("posts")
    @GET("users")
    fun getInformation():Call<List<InformationItem>>
}