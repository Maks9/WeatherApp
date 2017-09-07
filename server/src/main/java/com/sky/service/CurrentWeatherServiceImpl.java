package com.sky.service;

import com.sky.config.AppPropertiesHolder;
import com.sky.dao.repositories.CurrentWeatherRepository;
import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.model.CurrentMeteorologicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentWeatherServiceImpl.class);

    private final CurrentWeatherRepository currentWeatherRepository;
    private final AppPropertiesHolder.MeteoData meteoData;
    private final AppPropertiesHolder.MeteoData.Api api;

    @Autowired
    public CurrentWeatherServiceImpl(CurrentWeatherRepository currentWeatherRepository, AppPropertiesHolder appPropertyHolder) {
        this.currentWeatherRepository = currentWeatherRepository;
        this.meteoData = appPropertyHolder.getMeteoData();
        this.api = appPropertyHolder.getMeteoData().getApi();
    }

    @Override
    public CurrentMeteorologicalData getCurrentMeteoData(String cityName) throws GetCurrentMeteoDataException {

        RestTemplate restTemplate = new RestTemplate();

        URI request = UriComponentsBuilder.fromHttpUrl(api.getUri().getCurrentMeteoData())
                .queryParam(api.getParams().getCity(), cityName)
                .queryParam(api.getParams().getApiKey(), meteoData.getApiKey())
                .queryParam("units", "metric")
                .build().toUri();

        CurrentMeteorologicalData currentMeteorologicalData;
        try {
            currentMeteorologicalData = restTemplate.getForObject(request, CurrentMeteorologicalData.class);
        } catch (RestClientException e) {
            LOGGER.error(String.format("Get current meteo data for %s - FAILED.", cityName), e);
            throw new GetCurrentMeteoDataException("Can't get current weather");
        }

        LOGGER.info(String.format("Get current weather for %s - OK.", cityName));

        currentWeatherRepository.save(currentMeteorologicalData);

        LOGGER.info(String.format("Current weather response for %s - saved in database", cityName));

        return currentMeteorologicalData;

    }

    @Override
    public CurrentMeteorologicalData getCurrentMeteoData(String cityName, String countryCode) throws GetCurrentMeteoDataException {
        return getCurrentMeteoData(cityName + "," + countryCode);
    }
}
