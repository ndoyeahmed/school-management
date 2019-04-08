package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Mois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoisRepository extends JpaRepository<Mois, Long> {
}
