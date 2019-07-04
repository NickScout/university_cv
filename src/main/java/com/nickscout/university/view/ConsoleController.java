package com.nickscout.university.view;

import com.nickscout.university.model.Department;
import org.springframework.transaction.annotation.Transactional;

public interface ConsoleController {

    void showHead (Department department);
    void showStatistics (Department department);
    void showAverageSalary(Department department);
    void showLectorsCount(Department department);
    void showSearchResult(String query);

}
