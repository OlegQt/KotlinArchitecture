package com.kotlinarchitecture.data.dto

class ProductSearchResponse(
    val products: List<ProductDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
) : Response(
)
