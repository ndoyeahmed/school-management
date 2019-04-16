package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
    @Query("select e from Etablissement e where e.ville.id=:id and e.isArchiver=false and e.etat=true ")
    public Optional<List<Etablissement>> getAllByVille(@Param("id") Long id);
}
