package com.sky.service;

import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;

public interface CurrentWeatherService {

    public CurrentMeteorologicalData getCurrentMeteoData(String cityName) throws GetCurrentMeteoDataException;

    CurrentMeteorologicalData getCurrentMeteoData(String cityName, String countryCode) throws GetCurrentMeteoDataException;
}
