package com.nickscout.university.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public interface DepartmentInterface {
    Lector getHead();
    @JsonIgnore
    Set<Lector> getAllLectors();
    Set<Lector> getAllLectorsByDegree(Degree degree);
    @JsonIgnore
    double getAverageSalary();
    int countLectors();
    int countLectorsByDegree(Degree degree);
}
