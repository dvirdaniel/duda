package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PUPIL")
public class PupilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "LAT", nullable = false)
    private Double lat;

    @Column(name = "LON", nullable = false)
    private Double lon;

    @ManyToOne
    @JoinColumn(name = "SCHOOL_ID", referencedColumnName = "ID")
    private SchoolEntity schoolEntity;

    @OneToMany(mappedBy = "pupilId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradeEntity> grades;

    public Long getId() {
        return id;
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

    public SchoolEntity getSchoolEntity() {
        return schoolEntity;
    }

    public void setSchoolEntity(SchoolEntity schoolEntity) {
        this.schoolEntity = schoolEntity;
    }

    public List<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEntity> grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PupilEntity that = (PupilEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getGPA() {

        int sum = 0;
        int numOfGrades = grades.size();

        if (numOfGrades == 0) {
            return 0;
        } else {

            for (GradeEntity grade : grades) {
                sum += grade.getGrade();
            }
            return sum / grades.size();
        }
    }
}
