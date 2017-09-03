package com.sky.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fmandryka on 29.08.2017.
 */

@Component
@ConfigurationProperties(prefix = "application")
public class AppPropertiesHolder {


}
