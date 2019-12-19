package com.example.demo.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FRIENDSHIP")
public class FriendshipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "FIRST_PUPIL_ID", nullable = false)
    private Long firstPupilId;

    @Column(name = "SECOND_PUPIL_ID", nullable = false)
    private Long secondPupilId;

    public Long getId() {
        return id;
    }

    public Long getFirstPupilId() {
        return firstPupilId;
    }

    public void setFirstPupilId(Long firstPupilId) {
        this.firstPupilId = firstPupilId;
    }

    public Long getSecondPupilId() {
        return secondPupilId;
    }

    public void setSecondPupilId(Long secondPupilId) {
        this.secondPupilId = secondPupilId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendshipEntity that = (FriendshipEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
