package com.logbook.loogbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.logbook.loogbook.model.Activities;
import com.logbook.loogbook.repository.LogRepository;
import com.logbook.loogbook.service.InterLogbook;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class controller {

    @Autowired
    private InterLogbook logServ;

    @Autowired
    public LogRepository repo;

    @GetMapping("/all")
    @ResponseBody
    public List<Activities> getActivities() {
        return logServ.getAll();
    }

}
