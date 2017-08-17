package com.sky.dao.repositories;

import com.sky.model.CurrentWhether;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Admin on 17.08.2017.
 */
public interface CurrentWeatherRepository extends CrudRepository<CurrentWhether,Integer> {


}

