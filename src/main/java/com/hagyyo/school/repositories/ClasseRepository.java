package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    @Query("select c from Classe c where c.archiver = false ")
    public Optional<List<Classe>> all();
}
