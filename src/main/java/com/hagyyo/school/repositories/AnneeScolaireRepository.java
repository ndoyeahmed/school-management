package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.AnneScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneScolaire, Long> {
}
