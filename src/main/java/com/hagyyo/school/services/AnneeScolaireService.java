package com.hagyyo.school.services;

import com.hagyyo.school.entities.AnneScolaire;
import com.hagyyo.school.repositories.AnneeScolaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AnneeScolaireService {
    @Autowired
    private AnneeScolaireRepository anneeScolaireRepository;

    public boolean add(AnneScolaire anneScolaire) {
        if (anneScolaire.isEncours()) {
            List<AnneScolaire> anneScolaires = anneeScolaireRepository.findAll();
            if (anneScolaires.size() > 0) {
                anneScolaires.forEach(anneScolaire1 -> {
                    anneScolaire1.setEncours(false);
                    anneeScolaireRepository.save(anneScolaire1);
                });
            }
        } else {
            anneScolaire.setDateAjout(Timestamp.valueOf(LocalDateTime.now()));
        }
       anneeScolaireRepository.save(anneScolaire);
       return true;
    }
}
