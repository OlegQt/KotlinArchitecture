package com.kotlinarchitecture.domain.repository

import com.kotlinarchitecture.domain.model.CityInfo

interface CityInfoRepository {
    fun addCityToRepository(citySafeParam:CityInfo)
    fun loadCityFromRepository():CityInfo
}