package com.snaulx.weatherapp.api

import com.snaulx.weatherapp.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeather {
    @GET("weather?appid=${BuildConfig.apiKey}")
    fun currentWeather(@Query("lan") lan: Int, @Query("lat") lat: Int): Call<WeatherResponse>
}