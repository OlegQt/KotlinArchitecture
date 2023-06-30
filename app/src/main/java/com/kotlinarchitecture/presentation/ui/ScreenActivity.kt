package com.kotlinarchitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.kotlinarchitecture.data.dto.ProductDto
import com.kotlinarchitecture.data.dto.ProductSearchResponse
import com.kotlinarchitecture.data.network.DummyProductApiService
import com.kotlinarchitecture.data.network.RetrofitNetworkClient
import com.kotlinarchitecture.data.repository.CityInfoRepositoryImpl
import com.kotlinarchitecture.data.repository.DummyProductListRepositoryImpl
import com.kotlinarchitecture.databinding.ActivityScreenBinding
import com.kotlinarchitecture.domain.model.CityInfo
import com.kotlinarchitecture.domain.usecase.LoadCityInfoUseCase
import com.kotlinarchitecture.domain.usecase.LoadDummyProductListUseCase
import com.kotlinarchitecture.domain.usecase.SafeCityInfoUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScreenBinding

    private lateinit var cityRepo: CityInfoRepositoryImpl
    private lateinit var productRepo: DummyProductListRepositoryImpl
    private lateinit var loadCities: LoadCityInfoUseCase
    private lateinit var safeUseCase: SafeCityInfoUseCase
    private lateinit var loadDummyProducts: LoadDummyProductListUseCase

    private lateinit var vm: ScreenViewModel

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
        productRepo = DummyProductListRepositoryImpl(client = RetrofitNetworkClient())

        loadCities = LoadCityInfoUseCase(cityInfoRepo = cityRepo)
        safeUseCase = SafeCityInfoUseCase(cityInfoRepo = cityRepo)
        loadDummyProducts = LoadDummyProductListUseCase(repository = productRepo)

        vm = ViewModelProvider(this)[ScreenViewModel::class.java]

        // Binding implementation
        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observable pattern
        vm.getLifeData().observe(this) {
            showDlg(it)
        }

        // Button LOAD Listener
        binding.btnLoad.setOnClickListener {
            val city = loadCities.execute()
            showDlg(city.name)
        }

        // Button SAFE Listener
        binding.btnSafe.setOnClickListener {
            safeUseCase.execute(CityInfo(binding.txt.text.toString(), 1000000L))
        }

        // Button RetrofitCheck
        binding.btnLoadProducts.setOnClickListener {

            // Загрузили данные асинхронно с главным потоком
            val x = loadDummyProducts.execute() as List<ProductDto>

            // вывод данных
            val msgBuilder = StringBuilder()
            x.forEach {
                with(msgBuilder){
                    append(it.title).append("\n")
                }
            }
            showDlg(msgBuilder.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        //showDlg("Resume function invoke!")
    }
}