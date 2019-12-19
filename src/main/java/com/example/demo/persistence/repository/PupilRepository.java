package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.PupilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepository extends JpaRepository<PupilEntity, Long> {

    @Query("SELECT count(p) FROM PupilEntity p, FriendshipEntity f WHERE p.schoolEntity.id = :schoolId and f.firstPupilId = p.id and f.secondPupilId = :pupilId")
    Integer findAllFriendsByPupilIdAndSchoolId(Long pupilId, Long schoolId);

    @Query("SELECT count(p) FROM PupilEntity p WHERE p.schoolEntity.id = :schoolId")
    Integer findAllEnrolledBySchoolId(Long schoolId);
}
