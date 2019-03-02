package com.hagyyo.school.repositories;

import com.hagyyo.school.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.compte.email=:login and u.etat=:etat")
    public Optional<Utilisateur> connexion(@Param("login") String login, @Param("etat") Boolean etat);

    @Query("SELECT u FROM Utilisateur u WHERE u.id IN (SELECT pu FROM ProfilUtilisateur pu WHERE pu.profil.id=(SELECT p FROM Profil p WHERE p.nom=:profil))")
    public Optional<List<Utilisateur>> commsercialList(@Param("profil") String profil);
}
