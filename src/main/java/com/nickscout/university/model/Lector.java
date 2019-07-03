package com.nickscout.university.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter @ToString
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
    @JoinTable(
            name = "departments_lectors",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments;

    public Lector() {
        departments = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lector lector = (Lector) o;
        return id == lector.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
