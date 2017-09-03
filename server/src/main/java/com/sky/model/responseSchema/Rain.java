package com.sky.model.responseSchema;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Admin on 03.09.2017.
 */
public class Rain {


    private Double rainFor3Hours;

    /**
     * No args constructor for use in serialization
     */
    public Rain() {
    }

    public Rain(Double rainFor3Hours) {
        super();
        this.rainFor3Hours = rainFor3Hours;
    }

    @JsonProperty("3h")
    public Double getRainFor3Hours() {
        return rainFor3Hours;
    }

    @JsonProperty("3h")
    public void setRainFor3Hours(Double rainFor3Hours) {
        this.rainFor3Hours = rainFor3Hours;
    }
}
