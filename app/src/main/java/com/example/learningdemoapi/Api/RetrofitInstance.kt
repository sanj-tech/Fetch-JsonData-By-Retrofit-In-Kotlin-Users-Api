package com.example.learningdemoapi.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var retrofit:Retrofit?=null
    //var Base_url="https://reqres.in/api/"

    var BaseUrl="https://jsonplaceholder.typicode.com/"
    fun getRetrofitInstance():Retrofit? {
        if (retrofit==null){
            retrofit=Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }


return retrofit
    }

}