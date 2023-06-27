package com.kotlinarchitecture.app

class Coordinator private constructor(){
    var callSum = 0

    private fun callConstructor(){
        this.callSum++
    }

    companion object {
        private var instance:Coordinator? = null

        fun getInstance(): Coordinator {
            if(instance == null)  instance=Coordinator()
            else this.instance?.callConstructor()

            return instance!!
        }

        const val SHARED_PREFS_CODE:String = "SHARED_PREFS"
    }


}