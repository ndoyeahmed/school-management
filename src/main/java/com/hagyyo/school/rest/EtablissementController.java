package com.hagyyo.school.rest;

import com.hagyyo.school.entities.Etablissement;
import com.hagyyo.school.repositories.EtablissementRepository;
import com.hagyyo.school.services.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EtablissementController {

    @Autowired private EtablissementService etablissementService;

    @Autowired private EtablissementRepository etablissementRepository;

    @PostMapping("/list-etablissements")
    public ResponseEntity<List<Etablissement>> listeRegions(@RequestBody String id) {
        return new ResponseEntity<>(etablissementRepository.getAllByVille(Long.valueOf(id))
                .map(villes -> villes).orElse(new ArrayList<>()), HttpStatus.OK);
    }
}
