package com.sky.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.Entity;
import javax.persistence.Id;


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
    private short humidity;
    private short visibility;
    private float windSpeed;
    private short windDirection;
    private float rainVolume;
    private float snowVolume;
    private short cloudness;

    private int sunrise;
    private int sunset;

    private int timeOfCalculation;

    public CurrentMeteorologicalData(){
    }

    public CurrentMeteorologicalData(int cityID, String cityName, String countryCode, double coordLon, double coordLat, String weatherStatus, String weatherDescription, String weatherIconName, float temperature, short pressure, short humidity, short visibility, float windSpeed, short windDirection, float rainVolume, float snowVolume, short cloudness, int sunrise, int sunset, int timeOfCalculation) {
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

    @JsonProperty("id")
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    @JsonProperty("name")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("sys")
    public void setCountryCode(JsonNode sys) {
        this.countryCode = sys.get("country").textValue();
    }

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    @JsonProperty("coord")
    public void setCoordLon(JsonNode coord) {
        this.coordLon = coord.get("lon").asDouble();
    }

    public double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(double coordLat) {
        this.coordLat = coordLat;
    }

    @JsonProperty("coord")
    public void setCoordLat(JsonNode coord) {
        this.coordLat = coord.get("lat").asDouble();
    }

    public String getWeatherStatus() {
        return weatherStatus;
    }

    public void setWeatherStatus(String weatherStatus) {
        this.weatherStatus = weatherStatus;
    }

    @JsonProperty("weather")
    public void setWeatherStatus(JsonNode weather) {
        this.weatherStatus = weather.get("main").textValue();
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @JsonProperty("weather")
    public void setWeatherDescription(JsonNode weather) {
        this.weatherDescription = weather.get("description").textValue();
    }

    public String getWeatherIconName() {
        return weatherIconName;
    }

    public void setWeatherIconName(String weatherIconName) {
        this.weatherIconName = weatherIconName;
    }

    @JsonProperty("weather")
    public void setWeatherIconName(JsonNode weather) {
        this.weatherIconName = weather.get("icon").textValue();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("main")
    public void setTemperature(JsonNode main) {
        this.temperature = main.get("temp").floatValue();
    }

    public short getPressure() {
        return pressure;
    }

    public void setPressure(short pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("main")
    public void setPressure(JsonNode main) {
        this.pressure = main.get("pressure").shortValue();
    }

    public short getHumidity() {
        return humidity;
    }

    public void setHumidity(short humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("main")
    public void setHumidity(JsonNode main) {
        this.humidity = main.get("humidity").shortValue();
    }

    public short getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(short visibility) {
        this.visibility = visibility;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("wind")
    public void setWindSpeed(JsonNode wind) {
        this.windSpeed = wind.get("speed").shortValue();
    }

    public short getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(short windDirection) {
        this.windDirection = windDirection;
    }

    @JsonProperty("wind")
    public void setWindDirection(JsonNode wind) {
        this.windDirection = wind.get("deg").shortValue();
    }

    public float getRainVolume() {
        return rainVolume;
    }

    public void setRainVolume(float rainVolume) {
        this.rainVolume = rainVolume;
    }

    @JsonProperty("rain")
    public void setRainVolume(JsonNode rain) {
        this.rainVolume = rain.get("3h").shortValue();
    }

    public float getSnowVolume() {
        return snowVolume;
    }

    public void setSnowVolume(float snowVolume) {
        this.snowVolume = snowVolume;
    }

    @JsonProperty("snow")
    public void setSnowVolume(JsonNode snow) {
        this.snowVolume = snow.get("3h").shortValue();
    }

    public short getCloudness() {
        return cloudness;
    }

    public void setCloudness(short cloudness) {
        this.cloudness = cloudness;
    }

    @JsonProperty("clouds")
    public void setCloudness(JsonNode clouds) {
        this.cloudness = clouds.get("all").shortValue();
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sys")
    public void setSunrise(JsonNode sys) {
        this.sunrise = sys.get("sunrise").intValue();
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("sys")
    public void setSunset(JsonNode sys) {
        this.sunset = sys.get("sunset").intValue();
    }

    public int getTimeOfCalculation() {
        return timeOfCalculation;
    }

    @JsonProperty("dt")
    public void setTimeOfCalculation(int timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }

}
