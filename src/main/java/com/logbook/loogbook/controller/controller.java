package com.logbook.loogbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<List<Activities>> addActivity(@RequestBody Activities activity) {
        repo.save(activity);
        List<Activities> activities = getActivities();
        return ResponseEntity.ok(activities);
    }

    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<List<Activities>> editActivity(@RequestBody Activities activity, @PathVariable Long id) {
        Activities actTemp = logServ.searchActivity(id);
        String newDate = activity.getDate();
        String newNote = activity.getNotes();
        String newAct = activity.getActivity();
        actTemp.setActivity(newAct);
        actTemp.setDate(newDate);
        actTemp.setNotes(newNote);
        List<Activities> activities = getActivities();
        return ResponseEntity.ok(activities);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Activities>> deleteActivity(@PathVariable Long id) {
        logServ.deleteActivity(id);
        List<Activities> activities = getActivities();
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activities> getActivity(@PathVariable Long id) {
        Activities activity = logServ.searchActivity(id);
        return ResponseEntity.ok(activity);
    }

}
