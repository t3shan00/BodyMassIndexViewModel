package com.example.bodymassindexviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    var bmi by mutableStateOf("0.00")
        private set

    private val formatter = DecimalFormat("0.00")

    fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        bmi = if (weight > 0 && height > 0) formatter.format(weight / (height * height)) else "0.00"
    }
}