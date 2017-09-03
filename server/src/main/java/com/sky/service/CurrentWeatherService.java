package com.sky.service;

import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;

/**
 * Created by fmandryka on 18.08.2017.
 */
public interface CurrentWeatherService {

    public CurrentMeteorologicalData getCurrentMeteoData(String cityName) throws GetCurrentMeteoDataException;

}
