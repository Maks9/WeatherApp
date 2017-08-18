package com.sky.dao.repositories;

import com.sky.model.CurrentMeteorologicalData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Admin on 17.08.2017.
 */
public interface CurrentWeatherRepository extends CrudRepository<CurrentMeteorologicalData,Integer> {


}

