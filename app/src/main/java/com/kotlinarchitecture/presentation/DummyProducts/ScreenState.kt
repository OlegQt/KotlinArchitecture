package com.kotlinarchitecture.presentation.DummyProducts

sealed interface ScreenState {
    data class Error(
        val errorMessage: String
    ) : ScreenState
}