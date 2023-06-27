package com.kotlinarchitecture.data.network

import android.util.Log
import com.kotlinarchitecture.data.dto.NetworkClient
import com.kotlinarchitecture.data.dto.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient : NetworkClient {
    private val dummyProductBaseUrl = "https://dummyjson.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(dummyProductBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val dummyProductService = retrofit.create(DummyProductApiService::class.java)

    override fun doRequest(dto: Any?): Response {
        val response = dummyProductService.getProductList().execute()
        val body = response.body() ?: Response()
        body.resultCode = response.code()
        Log.e("response","networkClient return")
        return body
    }
}