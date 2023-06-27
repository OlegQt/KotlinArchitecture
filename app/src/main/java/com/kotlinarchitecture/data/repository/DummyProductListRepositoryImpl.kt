package com.kotlinarchitecture.data.repository

import android.util.Log
import com.kotlinarchitecture.data.dto.NetworkClient
import com.kotlinarchitecture.data.dto.ProductDto
import com.kotlinarchitecture.data.dto.ProductSearchResponse
import com.kotlinarchitecture.domain.repository.DummyProductRepository

class DummyProductListRepositoryImpl(private val client:NetworkClient):DummyProductRepository{
    override fun loadListProduct(): List<ProductDto> {
        val response = client.doRequest(null)

        if(response.resultCode==200){
            val resp:ProductSearchResponse = response as ProductSearchResponse
            Log.e("response","repo return")
            return resp.products
        }
        else return emptyList()
    }

}