package com.nickscout.university.controller;

import com.nickscout.university.model.Department;
import org.springframework.transaction.annotation.Transactional;

public interface ConsoleController {

    void showHead (Department department);
    @Transactional
    void showStatistics (Department department);
    @Transactional
    void showAverageSalary(Department department);
    @Transactional
    void showLectorsCount(Department department);
    @Transactional
    void showSearchResult(String query);

}
