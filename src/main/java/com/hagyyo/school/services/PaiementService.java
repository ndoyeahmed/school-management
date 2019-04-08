package com.hagyyo.school.services;

import com.hagyyo.school.entities.Mois;
import com.hagyyo.school.entities.TypePaiement;
import com.hagyyo.school.repositories.MoisRepository;
import com.hagyyo.school.repositories.TypePaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaiementService {
    @Autowired private MoisRepository moisRepository;

    @Autowired private TypePaiementRepository typePaiementRepository;

    public List<Mois> allMois() {
        return moisRepository.findAll();
    }

    public List<TypePaiement> allTypePaiement() {
        return typePaiementRepository.findAll();
    }
}
