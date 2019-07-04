package com.nickscout.university.repository;

import com.nickscout.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query(value = "select l from Lector l where locate(?1, l.firstName) > 0 or locate(?1, l.secondName) > 0")
    Set<Lector> findLectorsByPartialName(String name);

    @Query(value = "SELECT * FROM department d LIMIT ?1",
    nativeQuery = true)
    Set<Lector> findAllWithLimit(int limit);
}
