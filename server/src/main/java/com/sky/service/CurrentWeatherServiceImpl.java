package com.sky.service;

import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fmandryka on 18.08.2017.
 */

@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentWeatherServiceImpl.class);

    private final CurrentWeatherRepository currentWeatherRepository;

    @Override
    public CurrentMeteorologicalData getCurrentMeteoData(String cityName) throws GetCurrentMeteoDataException {
        return null;
    }
}
