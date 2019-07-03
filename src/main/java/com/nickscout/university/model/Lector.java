package com.nickscout.university.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Lector {
    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private long id;
    private String firstName;
    private String secondName;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @ManyToMany
    @JoinTable(name = "departments_lectors")
    private Set<Department> departments;

}
