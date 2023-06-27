package com.kotlinarchitecture.domain.usecase

import com.kotlinarchitecture.domain.model.CityInfo
import com.kotlinarchitecture.domain.repository.CityInfoRepository

class LoadCityInfoUseCase (private val cityInfoRepo: CityInfoRepository){
    fun execute(): CityInfo{
        return cityInfoRepo.loadCityFromRepository()
    }
}