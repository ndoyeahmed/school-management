package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.ProfilUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilUtilisateurRepository extends JpaRepository<ProfilUtilisateur, Long> {
    public Optional<ProfilUtilisateur> getDistinctByProfilIdAndUtilisateurId(Long profil, Long user);

    @Query("SELECT pu FROM ProfilUtilisateur pu WHERE pu.profil.nom=:profil AND pu.utilisateur.id=:utilisateur")
    public Optional<ProfilUtilisateur> getDistinctByProfilAndAndUtilisateur(@Param("profil") String profil, @Param("utilisateur") Long utilisateur);
}
