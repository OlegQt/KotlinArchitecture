package com.kotlinarchitecture.domain.usecase

import com.kotlinarchitecture.domain.model.CityInfo
import com.kotlinarchitecture.domain.repository.CityInfoRepository

class SafeCityInfoUseCase(private val cityInfoRepo: CityInfoRepository) {
    fun execute(citySafeParam: CityInfo): Boolean {
        cityInfoRepo.addCityToRepository(citySafeParam)
        return true
    }
}