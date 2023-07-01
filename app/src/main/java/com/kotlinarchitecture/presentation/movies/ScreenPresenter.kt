package com.kotlinarchitecture.presentation.movies

import android.content.Context
import com.kotlinarchitecture.data.dto.ProductDto
import com.kotlinarchitecture.data.network.RetrofitNetworkClient
import com.kotlinarchitecture.data.repository.DummyProductListRepositoryImpl
import com.kotlinarchitecture.domain.repository.DummyProductRepository
import com.kotlinarchitecture.domain.usecase.LoadDummyProductListUseCase

class ScreenPresenter(private val view: ScreenView, val context: Context) {
    fun loadDummyProducts() {
        val productRepo: DummyProductListRepositoryImpl =
            DummyProductListRepositoryImpl(RetrofitNetworkClient())
        val loadProducts = LoadDummyProductListUseCase(productRepo)

        val products = loadProducts.execute()
        if (products is List<*>) {
            val strBld = java.lang.StringBuilder()
            products.forEach {
                with(strBld){
                    if (it is ProductDto) append(it.title+"\n")
                }
            }
            view.showPlaceHolderMsg(strBld.toString())
        }
    }

}