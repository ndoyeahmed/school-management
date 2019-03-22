package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Query("select v from Ville v where v.region.id=:id")
    public Optional<List<Ville>> findAllByRegion(@Param("id") Long id);
}
