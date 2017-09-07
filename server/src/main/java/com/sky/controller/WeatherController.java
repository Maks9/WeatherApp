package com.sky.controller;

import com.sky.exceptions.GetCurrentMeteoDataException;
import com.sky.service.CurrentWeatherService;
import com.sky.model.CurrentMeteorologicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;


@RestController /*@Controller and @ResponseBody*/
public class WeatherController {

    @Autowired
    private final CurrentWeatherService currentWeatherService;

    public WeatherController(CurrentWeatherService currentWeatherService) {
        this.currentWeatherService = currentWeatherService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);

    @RequestMapping(value = "/current/meteo_data/get", method = RequestMethod.GET)
    public ResponseEntity<CurrentMeteorologicalData> getCurrentMeteorologicalData(@RequestParam String city) throws GetCurrentMeteoDataException {

        ResponseEntity<CurrentMeteorologicalData> currentMeteorologicalData = new ResponseEntity<>(currentWeatherService.getCurrentMeteoData(city), HttpStatus.OK);
        LOGGER.info("CurrentMeteorologicalData get - OK, city name {}", city);
        return currentMeteorologicalData;
    }

    @RequestMapping(value = "/current/meteo_data/getWithCountryCode", method = RequestMethod.GET)
    public ResponseEntity<CurrentMeteorologicalData> getCurrentMeteorologicalData(@RequestParam String city, @RequestParam String countryCode) throws GetCurrentMeteoDataException {

        ResponseEntity<CurrentMeteorologicalData> currentMeteorologicalData = new ResponseEntity<>(currentWeatherService.getCurrentMeteoData(city, countryCode), HttpStatus.OK);
        LOGGER.info("CurrentMeteorologicalData get - OK, city name {}", city);
        return currentMeteorologicalData;
    }

    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
    }
}
