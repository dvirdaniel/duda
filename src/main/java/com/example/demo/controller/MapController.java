package com.example.demo.controller;

import com.example.demo.service.PupilService;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Autowired
    private PupilService pupilService;

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("pupils", pupilService.getAllPupils());
        model.addAttribute("schools", pupilService.getAllPupils());

        // If the map was working
        //return "map";
        return "pupils";
    }
}
