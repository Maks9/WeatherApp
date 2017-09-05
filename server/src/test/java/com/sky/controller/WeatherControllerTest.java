package com.sky.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by Admin on 03.09.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"port=8082", "host=http://localhost:"})
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${port}")
    private String port;

    @Value("${host}")
    private String host;


    @Test
    public void testGetCurrentWeatherWithCountryPositive() throws Exception {
        URI request = UriComponentsBuilder.fromHttpUrl(host + port + "/meteo_data/get/city_only")
                .queryParam("city", "Kyiv")
                .queryParam("countryCode", "UA")
                .build().toUri();

        mockMvc.perform(get(request)).andExpect(status().isOk());
    }

    @Test
    public void testGetCurrentWeatherWithBadCountryPositive() throws Exception {
        URI request = UriComponentsBuilder.fromHttpUrl(host + port + "/meteo_data/get/city_with_code")
                .queryParam("city", "Kiev")
                .queryParam("countryCode", "not_exists")
                .build().toUri();

        mockMvc.perform(get(request)).andExpect(status().is(200));
    }

    @Test
    public void testGetCurrentWeatherNegative() throws Exception {
        URI request = UriComponentsBuilder.fromHttpUrl(host + port + "/meteo_data/get/city_only")
                .queryParam("city", "Dfsdfdsfa").build().toUri();

        mockMvc.perform(get(request)).andExpect(status().is(400));
    }

    @Test
    public void testGetCurrentWeatherWithCountryNegative() throws Exception {
        URI request = UriComponentsBuilder.fromHttpUrl(host + port + "/meteo_data/get/city_with_code")
                .queryParam("city", "dfdsfsdfds")
                .queryParam("countryCode", "UA")
                .build().toUri();

        mockMvc.perform(get(request)).andExpect(status().is(400));
    }

}
