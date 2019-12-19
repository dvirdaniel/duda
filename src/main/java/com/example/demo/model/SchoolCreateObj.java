package com.example.demo.model;

import javax.persistence.Column;

public class SchoolCreateObj {
    private Double lat;
    private Double lon;
    private Integer minimumGpa;
    private Integer maxNumberOfPupils;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Integer getMinimumGpa() {
        return minimumGpa;
    }

    public void setMinimumGpa(Integer minimumGpa) {
        this.minimumGpa = minimumGpa;
    }

    public Integer getMaxNumberOfPupils() {
        return maxNumberOfPupils;
    }

    public void setMaxNumberOfPupils(Integer maxNumberOfPupils) {
        this.maxNumberOfPupils = maxNumberOfPupils;
    }
}
