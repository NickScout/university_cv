package com.nickscout.university.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter
public class Lector {
    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private long id;
    private String firstName;
    private String secondName;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @ManyToMany
    @JoinTable(
            name = "departments_lectors",
            joinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id")
    )
    @Setter(AccessLevel.NONE)
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

    @Override
    public String toString() {
        return String.format("lector %s %s", firstName, secondName);
    }
}
