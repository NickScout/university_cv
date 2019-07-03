package com.nickscout.university.controller;

import com.nickscout.university.model.Degree;
import com.nickscout.university.model.Department;
import com.nickscout.university.model.Lector;
import com.nickscout.university.repository.DepartmentRepoository;
import com.nickscout.university.repository.LectorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Controller
public class Console implements ConsoleController {

    @Autowired
    DepartmentRepoository departmentRepoository;
    @Autowired
    LectorRepository lectorRepository;

    private Logger logger = LogManager.getLogger();

    @Override
    public void showHead(Department department) {
        Lector head = department.getHead();
        logger.info(String.format("Head of %s department is %s", department.toString(), head.toString()));
    }

    @Override
    public void showStatistics(Department department) {

        int assistantsCount = department.countLectorsByDegree(Degree.ASSISTANT);
        int professorsCount = department.countLectorsByDegree(Degree.PROFESSOR);
        int associateProfessorsCount = department.countLectorsByDegree(Degree.ASSOCIATE_PROFESSOR);

        StringBuilder sb = new StringBuilder();
        sb.append("assistans - ").append(assistantsCount).append(".\n")
                .append("associate professors - ").append(associateProfessorsCount).append(".\n")
                .append("professors - ").append(professorsCount).append(".\n");

        logger.info(sb.toString());
    }

    @Override
    public void showAverageSalary(Department department) {
        double salary = department.getAverageSalary();
        logger.info(String.format("The average salary of %s is %f", department.toString(), salary));
    }

    @Override
    public void showLectorsCount(Department department) {
        int count = department.countLectors();
        logger.info(count);
    }

    @Override
    public void showSearchResult(String query) {
        Set<Department> departments = departmentRepoository.findDepartmentsByPartialName(query);
        departments.forEach(department -> logger.info(department.toString()));
        Set<Lector> lectors = lectorRepository.findLectorsByPartialName(query);
        lectors.forEach(lector -> logger.info(lector.toString()));
    }


}
