package com.example.demo.service;

import com.example.demo.common.HaversineDistance;
import com.example.demo.model.SchoolCreateObj;
import com.example.demo.persistence.entity.PupilEntity;
import com.example.demo.persistence.entity.SchoolEntity;
import com.example.demo.persistence.repository.PupilRepository;
import com.example.demo.persistence.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private PupilRepository pupilRepository;

    public List<SchoolEntity> getAllSchools() {
        return schoolRepository.findAll();
    }

    public SchoolEntity getSchool(Long id) {
        return schoolRepository.getOne(id);
    }

    public Long addSchool(SchoolCreateObj schoolCreateObj) {
        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setLat(schoolCreateObj.getLat());
        schoolEntity.setLon(schoolCreateObj.getLon());
        schoolEntity.setMinimumGpa(schoolCreateObj.getMinimumGpa());
        schoolEntity.setMaxNumberOfPupils(schoolCreateObj.getMaxNumberOfPupils());
        return schoolRepository.save(schoolEntity).getId();
    }

    public SchoolEntity findSchoolToPupil(PupilEntity pupil) {

        // Check all by friends and distance
        double maxFormula = -1;
        SchoolEntity maxSchool = null;
        Integer enrolledPupils = 0;
        for (SchoolEntity school : schoolRepository.findAll()) {

            Double distanceFromSchool = HaversineDistance.getDistance(pupil.getLat(), pupil.getLon(), school.getLat(), school.getLon());
            Integer numOfFriends = pupilRepository.findAllFriendsByPupilIdAndSchoolId(pupil.getId(), school.getId());
            enrolledPupils = pupilRepository.findAllEnrolledBySchoolId(school.getId());
            double formula = numOfFriends * (1 / distanceFromSchool);
            if (formula > maxFormula) {
                maxFormula = formula;
                maxSchool = school;
            }
        }

        boolean isQualify = false;
        if (maxSchool != null) {
            isQualify = ((maxSchool.getMinimumGpa() < pupil.getGPA()) && (enrolledPupils < maxSchool.getMaxNumberOfPupils()));
        }

        if (!isQualify) {
            System.out.println("Not Qualified!");
            maxSchool = null;
        }

        return maxSchool;
    }
}
