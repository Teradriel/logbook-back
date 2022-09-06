package com.logbook.loogbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logbook.loogbook.model.Activities;
import com.logbook.loogbook.repository.LogRepository;

@Service
public class LogbookService implements InterLogbook {

    @Autowired
    public LogRepository repo;

    @Override
    public List<Activities> getAll() {
        return repo.findAll();
    }

    @Override
    public Activities searchActivity(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteActivity(Long id) {
        repo.deleteById(id);

    }

}
