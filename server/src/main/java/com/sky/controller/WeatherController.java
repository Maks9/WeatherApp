package com.sky.controller;

import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.service.CurrentWeatherService;
import com.sky.model.CurrentMeteorologicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Admin on 17.08.2017.
 */
@RestController /*@Controller and @ResponseBody*/
public class WeatherController {

    @Autowired
    private final CurrentWeatherService currentWeatherService;

    public WeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @RequestMapping(value = "/get/city", method = RequestMethod.GET)
    public ResponseEntity<CurrentMeteorologicalData> getCurrentMeteorologicalData(@RequestParam String city) throws GetCurrentMeteoDataException {

        ResponseEntity<CurrentMeteorologicalData> currentMeteorologicalData = new ResponseEntity<>(currentWeatherService.getWeatherByCityName(city), HttpStatus.OK);
        LOGGER.info("CurrentMeteorologicalData get - OK, city name {}", city);
        return currentMeteorologicalData;
    }

}
