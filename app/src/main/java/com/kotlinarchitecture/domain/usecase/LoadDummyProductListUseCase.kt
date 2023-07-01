package com.kotlinarchitecture.domain.usecase

import com.kotlinarchitecture.domain.repository.DummyProductRepository

class LoadDummyProductListUseCase(private val repository: DummyProductRepository) {
    fun execute(): Any? {
        var response: Any? = null
        val thread = Thread {
            response = repository.loadListProduct()
        }
        thread.start()
        thread.join()
        return response
    }
}