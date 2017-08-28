package com.service;

import com.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;

/**
 * Created by fmandryka on 18.08.2017.
 */
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    @Override
    public CurrentMeteorologicalData getWeatherByCityName(String cityName) throws GetCurrentMeteoDataException {
        return null;
    }
}
