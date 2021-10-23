package com.example.Test_task_Quilix.retrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.Test_task_Quilix.MainActivity
import com.example.Test_task_Quilix.R
import com.example.Test_task_Quilix.RateListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class ViewModel()  {
    /*
    private val base_url = "https://www.nbrb.by/Services/"


    fun start() {
        val retrofit = Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val apiDataInterface = retrofit.create(ApiDataInterface::class.java)

        val call = apiDataInterface.getRateList()
        call.enqueue(object: retrofit2.Callback<Currency> {
            override fun onResponse(call: Call<Currency>?, response: Response<Currency>?) {
                TODO("Not yet implemented")
                val recycler = (RecyclerView) findViewById(R.id.rateRV)
            }

            override fun onFailure(call: Call<Currency>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onResponse(call: Call<DailyExRates>?, response: Response<DailyExRates>?) {
        if (response!!.isSuccessful) {
            val der = response.body()
            val adapter = RateListAdapter(der.currencyList as MutableList<Currency>)

        }
    }

    override fun onFailure(call: Call<DailyExRates>?, t: Throwable?) {
        t!!.printStackTrace()
    }

     */
}