package com.nickscout.university.controller;

import com.nickscout.university.model.Department;
import com.nickscout.university.model.Lector;

public interface ConsoleController {
    void showHead (Department department);

    void showStatistics (Department department);

    void showAverageSalary (Department department);

    void showEmployeeCount(Department department);

    void showSearchResult(String query);

}
