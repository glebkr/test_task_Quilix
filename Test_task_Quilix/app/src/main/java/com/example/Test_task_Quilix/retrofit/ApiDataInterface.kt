package com.example.Test_task_Quilix.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiDataInterface {
    @GET("XmlExRates.aspx?ondate=10.23.2021")
    fun getRateList() : Call<DailyExRates>

}