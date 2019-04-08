package com.hagyyo.school.rest;

import com.hagyyo.school.entities.Mois;
import com.hagyyo.school.entities.TypePaiement;
import com.hagyyo.school.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaiementController {
    @Autowired private PaiementService paiementService;

    @GetMapping("/list-mois")
    public ResponseEntity<List<Mois>> listeMois() {
        List<Mois> mois = paiementService.allMois() ;
        return ResponseEntity.ok(mois);
    }

    @GetMapping("/list-type-paiement")
    public ResponseEntity<List<TypePaiement>> listeTypePaiement() {
        List<TypePaiement> typePaiements = paiementService.allTypePaiement() ;
        return ResponseEntity.ok(typePaiements);
    }
}
