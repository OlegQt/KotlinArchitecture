package com.kotlinarchitecture.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlinarchitecture.data.repository.CityInfoRepositoryImpl
import com.kotlinarchitecture.domain.usecase.LoadCityInfoUseCase
import com.kotlinarchitecture.domain.usecase.SafeCityInfoUseCase

class ScreenViewModel :ViewModel(){
    private lateinit var cityRepo: CityInfoRepositoryImpl
    private lateinit var loadCities: LoadCityInfoUseCase
    private lateinit var safeUseCase: SafeCityInfoUseCase

    private val resultLife = MutableLiveData<String>()

    fun getLifeData():LiveData<String> = this.resultLife

    override fun onCleared() {
        super.onCleared()
    }


}