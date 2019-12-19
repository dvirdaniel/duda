package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCHOOL")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "LAT", nullable = false)
    private Double lat;

    @Column(name = "LON", nullable = false)
    private Double lon;

    @Column(name = "MIN_GPA", nullable = false)
    private Integer minimumGpa;

    @Column(name = "MAX_NUM_PUPIL", nullable = false)
    private Integer maxNumberOfPupils;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolEntity that = (SchoolEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
