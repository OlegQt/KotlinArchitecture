package com.kotlinarchitecture.domain.repository

import com.kotlinarchitecture.data.dto.ProductDto

interface DummyProductRepository {
    fun loadListProduct():List<ProductDto>
}