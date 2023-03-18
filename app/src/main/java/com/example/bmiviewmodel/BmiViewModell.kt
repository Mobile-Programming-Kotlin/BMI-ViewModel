package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class BmiViewModell: ViewModel() {
    var weightInput by mutableStateOf("")
    var heightInput by mutableStateOf("")

    var bmi: Float = 0.0f
        get() {
            return calculate(heightInput.toFloatOrNull() ?: 0.00f) as Float
        }

    private var weight: Int = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    private fun calculate(height: Float): Float {
        return if (weight>0 && height>0) weight/(height*height) else 0.00f
    }
}