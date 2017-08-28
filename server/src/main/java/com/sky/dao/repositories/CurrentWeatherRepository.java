package com.sky.dao.repositories;

import com.sky.model.CurrentMeteorologicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentWeatherRepository extends JpaRepository<CurrentMeteorologicalData,Integer> {

}

