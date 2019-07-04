package com.nickscout.university.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
public class Department implements DepartmentInterface {

    @Column(unique = true)
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    @OneToOne
    private Lector head;
    @ManyToMany
    @JoinTable(
            name = "departments_lectors",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lector_id", referencedColumnName = "id")
    )
    @Setter(AccessLevel.NONE)
    private Set<Lector> lectors;

    public Department() {
        lectors = new HashSet<>();
    }

    @Override
    public Lector getHead() {
        return head;
    }

    @Override
    public Set<Lector> getAllLectors() {
        return lectors;
    }

    @Override
    public Set<Lector> getAllLectorsByDegree(Degree degree) {
        return lectors.stream()
                .filter(lector -> lector.getDegree() == degree)
                .collect(Collectors.toSet());
    }

    @Override
    public double getAverageSalary() {

        return lectors.stream()
                .mapToDouble(lector -> lector.getSalary())
                .average()
                .getAsDouble();
    }

    @Override
    public int countLectors() {
        return lectors.size();
    }

    @Override
    public int countLectorsByDegree(Degree degree) {
        return (int) lectors.stream()
                .filter(lector -> lector.getDegree() == degree)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("department of %s", name);
    }
}
