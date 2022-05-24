package com.snaulx.weatherapp.api

data class Coord(val lon: Int, val lat: Int)

data class WeatherDesc(val id: Int, val main: String, val description: String, val icon: String)

data class BaseWeather(val temp: Float, val feels_like: Float, val temp_min: Float, val temp_max: Float,
                       val pressure: Int, val humidity: Int)

data class Wind(val speed: Float, val deg: Int)

data class Clouds(val all: Float)

data class Place(val type: Int, val id: Int, val message: Float, val country: String, val sunrise: Long, val sunset: Long)

data class WeatherResponse(val coord: Coord, val weather: List<WeatherDesc>, val base: String, val main: BaseWeather,
                           val visibility: Int, val wind: Wind, val clouds: Clouds, val dt: Long, val sys: Place,
                           val timezone: Int, val id: Long, val name: String, val cod: Int)
