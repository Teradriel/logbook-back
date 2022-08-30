package com.logbook.loogbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logbook.loogbook.model.Activities;

@Repository
public interface LogRepository extends JpaRepository<Activities, Long> {

}
