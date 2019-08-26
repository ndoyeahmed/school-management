package com.hagyyo.school.rest;

import com.hagyyo.school.entities.AnneScolaire;
import com.hagyyo.school.repositories.AnneeScolaireRepository;
import com.hagyyo.school.services.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AnneeScolaireController {
    @Autowired
    private AnneeScolaireService anneeScolaireService;

    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    @PostMapping("/add-annee-scolaire")
    public ResponseEntity add(@RequestBody AnneScolaire anneScolaire) {
        try {
            return new ResponseEntity<>(Collections.singletonMap("success", anneeScolaireService.add(anneScolaire)),  HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-anne-scolaire")
    public ResponseEntity<List<AnneScolaire>> listeAnneeScolaire() {
        List<AnneScolaire> anneScolaires = anneeScolaireRepository.all().orElse(new ArrayList<>()) ;
        return ResponseEntity.ok(anneScolaires);
    }
}
