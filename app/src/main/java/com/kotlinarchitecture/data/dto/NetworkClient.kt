package com.kotlinarchitecture.data.dto

interface NetworkClient {
    fun doRequest(dto:Any?):Response
}