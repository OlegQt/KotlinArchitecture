package com.kotlinarchitecture.domain.usecase

import android.util.Log

import com.kotlinarchitecture.domain.repository.DummyProductRepository

class LoadDummyProductListUseCase(private val repository: DummyProductRepository) {
    fun execute():Any{
        return repository.loadListProduct()
    }
}