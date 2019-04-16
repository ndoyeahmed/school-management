package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.AnneScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneScolaire, Long> {
    @Query("select an from AnneScolaire an where an.archiver=false order by an.dateAjout desc ")
    public Optional<List<AnneScolaire>> all();
}
