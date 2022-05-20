package com.example.learningdemoapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.learningdemoapi.Api.EndUrlInterface
import com.example.learningdemoapi.Api.RetrofitInstance
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()

    }

    private fun getData() {
        var apiInterface =
            RetrofitInstance.getRetrofitInstance()?.create(EndUrlInterface::class.java)
        var call = apiInterface?.getInformation()
        call?.enqueue(object : Callback<List<InformationItem>> {
            override fun onResponse(
                call: Call<List<InformationItem>>,
                response: Response<List<InformationItem>>
            ) {
                if (response.body() != null) {
                    Log.d("Res", response.toString())
                   // tv.text=response.toString()

                    val responsBody = response.body()!!
                    val myStringBuilder = StringBuilder()
                for (data in responsBody) {
                    myStringBuilder.append(data.id)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.name)
                    myStringBuilder.append("\n")
                   myStringBuilder.append(data.username)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.email)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.address?.street)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.address?.city)
                    myStringBuilder.append("\n")

                    myStringBuilder.append(data.address?.geo?.lng)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.address?.geo?.lat)
                    myStringBuilder.append("\n")


                    myStringBuilder.append(data.company.name)
                    myStringBuilder.append(data.company.catchPhrase)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.company.bs)
                    myStringBuilder.append("\n")
                    myStringBuilder.append(data.phone)
                    myStringBuilder.append("\n")

                }
               tv.text = myStringBuilder




                }
            }



            override fun onFailure(call: Call<List<InformationItem>>, t: Throwable) {
                Log.i("Error", t.message.toString())
            }
        })

    }
}