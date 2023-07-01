package com.kotlinarchitecture.presentation.DummyProducts

interface ScreenView {
    // Методы, меняющие внешний вид экрана
    fun render(state: ScreenState)

    // Методы «одноразовых событий»
    fun showPlaceHolderMsg(msg:String)
}