package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    public Optional<Profil> getDistinctByNom(String nom);
}
