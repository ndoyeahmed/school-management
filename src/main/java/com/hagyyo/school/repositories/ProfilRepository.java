package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    @Query("select p from Profil p where p.nom=:nom and p.etat=true and p.isArchiver=false ")
    public Optional<Profil> getDistinctByNom(@Param("nom") String nom);

    @Query("select p from Profil p where p.nom NOT LIKE 'Super Administrateur' and p.etat=true and p.isArchiver=false ")
    public Optional<List<Profil>> allForAdministrateur();
}
