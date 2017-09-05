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

    public CurrentMeteorologicalData(int id, int cityID, String cityName, String countryCode, double coordLon, double coordLat, String weatherStatus, String weatherDescription, String weatherIconName, float temperature, short pressure, short humidity, short visibility, float windSpeed, short windDirection, float rainVolume, float snowVolume, short cloudness, int sunrise, int sunset, int timeOfCalculation) {
        this.id = id;
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
    public void setCountryCodeSinriseSunset(JsonNode sys) {
        this.countryCode = sys.get("country").textValue();
        this.sunrise = sys.get("sunrise").intValue();
        this.sunset = sys.get("sunset").intValue();
    }

    public double getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(double coordLon) {
        this.coordLon = coordLon;
    }

    @JsonProperty("coord")
    public void setCoordLonLat(JsonNode coord) {
        this.coordLon = coord.get("lon").asDouble();
        this.coordLat = coord.get("lat").asDouble();
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

    @JsonProperty("weather")
    public void setWeatherStatus(JsonNode weather) {
        this.weatherStatus = weather.get(0).get("main").textValue();
        this.weatherDescription = weather.get(0).get("description").textValue();
        this.weatherIconName = weather.get(0).get("icon").textValue();
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

    @JsonProperty("main")
    public void setTempPressHumid(JsonNode main) {
        this.temperature = main.get("temp").floatValue();
        this.pressure = main.get("pressure").shortValue();
        this.humidity = main.get("humidity").shortValue();
    }

    public short getPressure() {
        return pressure;
    }

    public void setPressure(short pressure) {
        this.pressure = pressure;
    }

    public short getHumidity() {
        return humidity;
    }

    public void setHumidity(short humidity) {
        this.humidity = humidity;
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
    public void setWind(JsonNode wind) {
        this.windSpeed = wind.get("speed").shortValue();
        this.windDirection = wind.get("deg").shortValue();
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

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getTimeOfCalculation() {
        return timeOfCalculation;
    }

    @JsonProperty("dt")
    public void setTimeOfCalculation(int timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }

}
