package com.service;

import com.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;

/**
 * Created by fmandryka on 18.08.2017.
 */
public interface CurrentWeatherService {

    public CurrentMeteorologicalData getWeatherByCityName(String cityName) throws GetCurrentMeteoDataException;

}
