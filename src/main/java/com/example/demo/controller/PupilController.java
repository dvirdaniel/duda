package com.example.demo.controller;

import com.example.demo.model.PupilCreateObj;
import com.example.demo.persistence.entity.PupilEntity;
import com.example.demo.service.FriendshipService;
import com.example.demo.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PupilController {

    @Autowired
    private PupilService pupilService;

    @Autowired
    private FriendshipService friendshipService;

    @GetMapping("/pupil")
    public List<PupilEntity> getAll() {
        return pupilService.getAllPupils();
    }

    @PostMapping(value = "/pupil", consumes = {"application/json"})
    public Long createSchool(@RequestBody PupilCreateObj pupilCreateObj) {
        return pupilService.addPupil(pupilCreateObj);
    }

    @PostMapping("/setFriendShip/{firstPupilId}/{secondPupilId}")
    public void setFriendShip(@PathVariable(value="firstPupilId") Long firstPupilId,
                              @PathVariable(value="secondPupilId") Long secondPupilId) {
        friendshipService.setFriendShip(firstPupilId, secondPupilId);
    }

    @PostMapping("/enroll/{pupilId}")
    public void enrollPupil(@PathVariable(value="pupilId") Long pupilId) {
        pupilService.enrollPupil(pupilId);
    }

}
