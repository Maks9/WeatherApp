package com.sky.model;

import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class CurrentMeteorologicalData {

    @Id
    private int id;

    private int cityID;

    private String cityName;
    private String countryCode;
    private double coordLon;
    private double coordLat;

    private String weatherStatus;
    private String weatherDescription;
    private String weatherIconName;
    private float temperature;
    private short pressure;
    private byte humidity;
    private short visibility;
    private float windSpeed;
    private short windDirection;
    private float rainVolume;
    private float snowVolume;
    private byte cloudness;

    private int sunrise;
    private int sunset;

    private int timeOfCalculation;

    public CurrentMeteorologicalData(){
    }

    public CurrentMeteorologicalData(int cityID, String cityName, String countryCode, double coordLon, double coordLat, String weatherStatus, String weatherDescription, String weatherIconName, float temperature, short pressure, byte humidity, short visibility, float windSpeed, short windDirection, float rainVolume, float snowVolume, byte cloudness, int sunrise, int sunset, int timeOfCalculation) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.coordLon = coordLon;
        this.coordLat = coordLat;
        this.weatherStatus = weatherStatus;
        this.weatherDescription = weatherDescription;
        this.weatherIconName = weatherIconName;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.rainVolume = rainVolume;
        this.snowVolume = snowVolume;
        this.cloudness = cloudness;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.timeOfCalculation = timeOfCalculation;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIconName() {
        return weatherIconName;
    }

    public void setWeatherIconName(String weatherIconName) {
        this.weatherIconName = weatherIconName;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public short getPressure() {
        return pressure;
    }

    public void setPressure(short pressure) {
        this.pressure = pressure;
    }

    public byte getHumidity() {
        return humidity;
    }

    public void setHumidity(byte humidity) {
        this.humidity = humidity;
    }

    public short getVisibility() {
        return visibility;
    }

    public void setVisibility(short visibility) {
        this.visibility = visibility;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public short getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(short windDirection) {
        this.windDirection = windDirection;
    }

    public float getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(float rainVolume) {
        this.rainVolume = rainVolume;
    }

    public float getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(float snowVolume) {
        this.snowVolume = snowVolume;
    }

    public byte getCloudness() {
        return cloudness;
    }

    public void setCloudness(byte cloudness) {
        this.cloudness = cloudness;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getTimeOfCalculation() {
        return timeOfCalculation;
    }

    public void setTimeOfCalculation(int timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }
}
