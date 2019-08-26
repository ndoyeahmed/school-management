package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    @Query("select n from Niveau n where n.archiver = false ")
    public Optional<List<Niveau>> all();
}
