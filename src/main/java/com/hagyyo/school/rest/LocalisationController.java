package com.hagyyo.school.rest;

import com.hagyyo.school.entities.Region;
import com.hagyyo.school.entities.Ville;
import com.hagyyo.school.repositories.RegionRepository;
import com.hagyyo.school.repositories.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalisationController {

    @Autowired private VilleRepository villeRepository;

    @Autowired private RegionRepository regionRepository;

    @GetMapping("/list-regions")
    public ResponseEntity<List<Region>> listeRegions() {
        List<Region> regions = regionRepository.findAll();
        return ResponseEntity.ok(regions);
    }

    @GetMapping("/list-villes")
    public ResponseEntity<List<Ville>> listeVille() {
        List<Ville> villes = villeRepository.findAll();
        return ResponseEntity.ok(villes);
    }

    @PostMapping("/list-villes-par-region")
    public ResponseEntity<List<Ville>> listVilleParRegion(@RequestBody String idRegion) {
        return new ResponseEntity<>(villeRepository.findAllByRegion(Long.valueOf(idRegion))
                .map(villes -> villes).orElse(new ArrayList<>()), HttpStatus.OK);
    }
}
