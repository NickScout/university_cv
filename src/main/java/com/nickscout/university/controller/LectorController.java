package com.nickscout.university.controller;

import com.nickscout.university.model.Lector;
import com.nickscout.university.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@RestController
public class LectorController {

    @Autowired
    LectorRepository lectorRepository;

    @GetMapping (value = "/lector/{id}")
    public ResponseEntity<Lector> getLector(@PathVariable long id) {
        Optional<Lector> optionalLector = lectorRepository.findById(id);
        if (optionalLector.isPresent()) {
            return new ResponseEntity<>(optionalLector.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = "/lector/")
    public ResponseEntity<Set<Lector>> getAllLectors(@RequestParam int limit) {
        Set<Lector> lectors = lectorRepository.findAllWithLimit(limit);
        return new ResponseEntity<>(lectors, HttpStatus.OK);
    }

    @PostMapping (value = "/lector/")
    public ResponseEntity<Lector> postLector (@RequestBody Lector lector) {
        if (lector != null) {
            lectorRepository.save(lector);
            return new ResponseEntity<>(lector, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping (value = "/lector/")
    public ResponseEntity<Collection<Lector>> postAllLectors(@RequestBody Collection<Lector> lectors) {
        if (lectors != null) {
            lectorRepository.saveAll(lectors);
            return new ResponseEntity<>(lectors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping (value = "/lector/")
    public ResponseEntity<Lector> deleteLector(@PathVariable long id) {
        lectorRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
