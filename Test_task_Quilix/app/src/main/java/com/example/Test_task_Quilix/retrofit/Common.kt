package com.example.Test_task_Quilix.retrofit

object Common {
    private val base_url = "https://www.nbrb.by/Services/"

    val apiDataInterface: ApiDataInterface
    get() = RetrofitClient.getClient(base_url).create(ApiDataInterface::class.java)
}