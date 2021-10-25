package com.example.Test_task_Quilix.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiDataInterface {
    @GET("api/exrates/rates?ondate=2021-10-26&periodicity=0")
    fun getRateListToday() : Call<MutableList<Currency>>

    @GET("api/exrates/rates?ondate=2021-10-27&periodicity=0")
    fun getRateListTomorrow() : Call<MutableList<Currency>>

    @GET("api/exrates/rates?ondate=2021-10-25&periodicity=0")
    fun getRateListYesterday() : Call<MutableList<Currency>>

}