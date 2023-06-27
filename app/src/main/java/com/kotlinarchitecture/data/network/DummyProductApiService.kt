package com.kotlinarchitecture.data.network

import com.kotlinarchitecture.data.dto.ProductSearchResponse
import retrofit2.Call
import retrofit2.http.GET

interface DummyProductApiService {
    @GET("products")
    fun getProductList():Call<ProductSearchResponse>
}