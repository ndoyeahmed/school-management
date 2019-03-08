package com.hagyyo.school.services;

import com.hagyyo.school.entities.Classe;
import com.hagyyo.school.entities.Cycle;
import com.hagyyo.school.entities.Niveau;
import com.hagyyo.school.repositories.ClasseRepository;
import com.hagyyo.school.repositories.CycleRepository;
import com.hagyyo.school.repositories.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ConfigurationEcoleService {

    @Autowired private CycleRepository cycleRepository;

    @Autowired private NiveauRepository niveauRepository;

    @Autowired private ClasseRepository classeRepository;

    public boolean addCycle(Cycle cycle) {
        if (cycle != null) {
            cycleRepository.save(cycle);
        }
        return true;
    }

    public boolean addNiveau(Niveau niveau) {
        if (niveau != null) {
            niveauRepository.save(niveau);
        }
        return true;
    }

    public boolean addClasse(Classe classe) {
        if (classe != null) {
            classeRepository.save(classe);
        }
        return true;
    }

    public List<Classe> allClasse() {
        return classeRepository.all().orElse(new ArrayList<>());
    }

    public List<Niveau> allNiveau() {
        return niveauRepository.all().orElse(new ArrayList<>());
    }

    public List<Cycle> allCycle() {
        return cycleRepository.all().orElse(new ArrayList<>());
    }

}
