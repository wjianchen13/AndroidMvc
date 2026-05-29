package com.example.androidmvc.mvi

data class WeatherState(
    val temperature: Float,
    val humidity: Float,
    val condition: String
)