package com.example.demo.controller;

import com.example.demo.model.SchoolCreateObj;
import com.example.demo.persistence.entity.SchoolEntity;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/school")
    public List<SchoolEntity> getAll() {
        return schoolService.getAllSchools();
    }

    @PostMapping(value = "/school", consumes = {"application/json"})
    public Long createSchool(@RequestBody SchoolCreateObj schoolCreateObj) {
        return schoolService.addSchool(schoolCreateObj);
    }
}
