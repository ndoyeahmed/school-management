package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementRepository extends JpaRepository<TypePaiement, Long> {
}
