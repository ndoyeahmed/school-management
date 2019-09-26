package com.hagyyo.school.services;

import com.hagyyo.school.repositories.EleveRepository;
import com.hagyyo.school.repositories.InscriptionRepository;
import com.hagyyo.school.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InscriptionService {
    @Autowired private InscriptionRepository inscriptionRepository;

    @Autowired private EleveRepository eleveRepository;

    @Autowired private ParentRepository parentRepository;
}
