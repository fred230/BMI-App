package com.fredrick.bmi


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    var weight = MutableLiveData<Int>()
    var age = MutableLiveData<Int>()


    init {
        age.value = 0

    }

    init {
        weight.value = 0
    }


    fun updateAgeAdd() {
        age.value = (age.value)?.plus(1)

    }

    fun updateAgeSubtract() {
        age.value = (age.value)?.minus(1)
    }


    fun updateWeightAdd() {
        weight.value = (weight.value)?.plus(1)
    }

    fun updateWeightSubtract() {
        weight.value = (weight.value)?.minus(1)
    }


}