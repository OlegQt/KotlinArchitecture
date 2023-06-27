package com.kotlinarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kotlinarchitecture.data.repository.CityInfoRepositoryImpl
import com.kotlinarchitecture.databinding.ActivityScreenBinding
import com.kotlinarchitecture.domain.model.CityInfo
import com.kotlinarchitecture.domain.usecase.LoadCityInfoUseCase
import com.kotlinarchitecture.domain.usecase.SafeCityInfoUseCase

class ScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScreenBinding

    private lateinit var cityRepo:CityInfoRepositoryImpl
    private lateinit var loadCities:LoadCityInfoUseCase
    private lateinit var safeUseCase:SafeCityInfoUseCase

    private lateinit var vm:ScreenViewModel

    private fun showDlg(msg: String) {
        MaterialAlertDialogBuilder(this)
            .setMessage(msg)
            .setTitle("Dialog")
            .setNeutralButton("OK", null)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Implementation
        cityRepo = CityInfoRepositoryImpl(context = this.applicationContext)
        loadCities = LoadCityInfoUseCase(cityInfoRepo = cityRepo)
        safeUseCase = SafeCityInfoUseCase(cityInfoRepo = cityRepo)

        vm =ViewModelProvider(this)[ScreenViewModel::class.java]

        // Binding implementation
        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observable pattern
        vm.getLifeData().observe(this){
            showDlg(it)
        }

        // Button LOAD Listener
        binding.btnLoad.setOnClickListener {
            val city = loadCities.execute()
            showDlg(city.name)
        }

        // Button SAFE Listener
        binding.btnSafe.setOnClickListener {
            safeUseCase.execute(CityInfo(binding.txt.text.toString(),1000000L))
        }
    }

    override fun onResume() {
        super.onResume()
        showDlg("Resume function invoke!")
    }
}