package com.sky.model.responseSchema;

/**
 * Created by Admin on 03.09.2017.
 */
public class Wind {

    private Double speed;
    private Integer deg;

    /**
     * No args constructor for use in serialization
     */
    public Wind() {
    }

    public Wind(Double speed, Integer deg) {
        super();
        this.speed = speed;
        this.deg = deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}
