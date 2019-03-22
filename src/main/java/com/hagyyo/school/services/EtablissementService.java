package com.hagyyo.school.services;

import com.hagyyo.school.entities.Etablissement;
import com.hagyyo.school.repositories.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EtablissementService {

    @Autowired private EtablissementRepository etablissementRepository;

    public List<Etablissement> getAllByVille(Long id) {
        return etablissementRepository.getAllByVille(id).orElse(new ArrayList<>());
    }
}
