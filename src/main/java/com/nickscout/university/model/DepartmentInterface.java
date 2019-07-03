package com.nickscout.university.model;

import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface DepartmentInterface {
    Lector getHead();
    Set<Lector> getAllLectors();
    Set<Lector> getAllLectorsByDegree(Degree degree);
    double getAverageSalary();
    int countLectors();
    int countLectorsByDegree(Degree degree);
}
