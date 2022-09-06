package com.logbook.loogbook.service;

import java.util.List;

import com.logbook.loogbook.model.Activities;

public interface InterLogbook {

    public List<Activities> getAll();

    public Activities searchActivity(Long id);

    public void deleteActivity(Long id);

}
