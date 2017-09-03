package com.sky.model.responseSchema;

/**
 * Created by Admin on 03.09.2017.
 */
public class Coordinates {

    private Double lon;
    private Double lat;

    /**
     * No args constructor for use in serialization
     */
    public Coordinates() {
    }

    public Coordinates(Double lon, Double lat) {
        super();
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}
