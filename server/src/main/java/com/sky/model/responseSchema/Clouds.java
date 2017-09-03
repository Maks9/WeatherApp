package com.sky.model.responseSchema;

/**
 * Created by Admin on 03.09.2017.
 */
public class Clouds {

    private Integer all;

    /**
     * No args constructor for use in serialization
     */
    public Clouds() {
    }

    public Clouds(Integer all) {
        super();
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }


}
