package com.kotlinarchitecture.data.repository

import android.content.Context
import com.kotlinarchitecture.domain.model.CityInfo
import com.kotlinarchitecture.domain.repository.CityInfoRepository

class CityInfoRepositoryImpl(context: Context) : CityInfoRepository {

    private val sharedPreferences = context.getSharedPreferences(SHAR, Context.MODE_PRIVATE)

    override fun addCityToRepository(citySafeParam: CityInfo) {
        sharedPreferences.edit().putString(CITY_NAME, citySafeParam.name).apply()
    }

    override fun loadCityFromRepository(): CityInfo {
        val cityName = sharedPreferences.getString(CITY_NAME, DEFAULT_CITY) ?: ""
        return CityInfo(cityName,999L)
    }

    companion object {
        const val SHAR = "SHARED_PREFS_CODE"
        const val CITY_NAME = "CITY_NAME"
        const val DEFAULT_CITY = "Moscow"
    }
}