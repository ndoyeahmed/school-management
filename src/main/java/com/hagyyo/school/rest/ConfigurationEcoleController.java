package com.hagyyo.school.rest;

import com.hagyyo.school.entities.Classe;
import com.hagyyo.school.entities.Cycle;
import com.hagyyo.school.entities.Niveau;
import com.hagyyo.school.services.ConfigurationEcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ConfigurationEcoleController {

    @Autowired private ConfigurationEcoleService configurationEcoleService;

    @PostMapping("/add-cycle")
    public ResponseEntity addCycle(@RequestBody Cycle cycle) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.addCycle(cycle)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete-cycle")
    public ResponseEntity deleteCycle(@RequestBody Cycle cycle) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.deleteCycle(cycle)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
//........Niveaux Controller...
    @PostMapping("/add-niveau")
    public ResponseEntity addNiveau(@RequestBody Niveau niveau) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.addNiveau(niveau)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update-niveau")
    public ResponseEntity updateNiveau(@RequestBody Niveau niveau) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.updateNiveau(niveau)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete-niveau")
    public ResponseEntity deleteNiveau(@RequestBody Niveau niveau) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.deleteNiveau(niveau)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-niveau")
    public ResponseEntity<List<Niveau>> listeNiveau() {
        List<Niveau> niveau = configurationEcoleService.allNiveau();
        return ResponseEntity.ok(niveau);
    }
//.......Fin Niveaux Controller......

    @PostMapping("/add-classe")
    public ResponseEntity addClasse(@RequestBody Classe classe) {
        try{
            return new ResponseEntity<>(Collections.singletonMap("success", configurationEcoleService.addClasse(classe)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-cycle")
    public ResponseEntity<List<Cycle>> listeCycle() {
        List<Cycle> cycles = configurationEcoleService.allCycle();
        return ResponseEntity.ok(cycles);
    }


    @GetMapping("/list-classe")
    public ResponseEntity<List<Classe>> listeClasse() {
        List<Classe> classes = configurationEcoleService.allClasse();
        return ResponseEntity.ok(classes);
    }
}
