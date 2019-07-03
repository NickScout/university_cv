package com.nickscout.university.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Department {

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private long id;

    @OneToOne
    private Lector head;
    @ManyToMany
    @JoinTable(name = "departments_lectors")
    private Set<Lector> lectors;

}
