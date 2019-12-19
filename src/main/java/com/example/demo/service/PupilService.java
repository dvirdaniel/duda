package com.example.demo.service;

import com.example.demo.model.GradeCreateObj;
import com.example.demo.model.PupilCreateObj;
import com.example.demo.persistence.entity.GradeEntity;
import com.example.demo.persistence.entity.PupilEntity;
import com.example.demo.persistence.repository.GradeRepository;
import com.example.demo.persistence.repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PupilService {

    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private SchoolService schoolService;

    public List<PupilEntity> getAllPupils() {
        return pupilRepository.findAll();
    }

    public PupilEntity getPupil(Long id) {
        return pupilRepository.getOne(id);
    }

    public Long addPupil(PupilCreateObj pupilCreateObj) {
        PupilEntity pupilEntity = new PupilEntity();
        pupilEntity.setLat(pupilCreateObj.getLat());
        pupilEntity.setLon(pupilCreateObj.getLon());
        PupilEntity newPupilEntity = pupilRepository.save(pupilEntity);

        // Set grades
        List<GradeEntity> grades = new LinkedList<>();
        for (GradeCreateObj gradeCreateObj : pupilCreateObj.getGrades()) {
            GradeEntity gradeEntity = new GradeEntity();
            gradeEntity.setCourseName(gradeCreateObj.getCourseName());
            gradeEntity.setGrade(gradeCreateObj.getGrade());
            gradeEntity.setPupilId(newPupilEntity.getId());
            grades.add(gradeEntity);
        }

        gradeRepository.saveAll(grades);

        return newPupilEntity.getId();
    }

    public void enrollPupil(Long id) {
        PupilEntity pupil = getPupil(id);
        pupil.setSchoolEntity(schoolService.findSchoolToPupil(pupil));
        pupilRepository.save(pupil);
    }
}
