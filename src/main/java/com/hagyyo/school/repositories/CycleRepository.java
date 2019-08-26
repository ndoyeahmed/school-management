package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Cycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
    @Query("select c from Cycle c where c.archiver=false ")
    public Optional<List<Cycle>> all();
}
