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

    @Query("select u from Utilisateur u where u.etablissement IS not null and u.etablissement.id=:id and u.isArchiver=false order by u.etat desc , u.date desc")
    public Optional<List<Utilisateur>> getAllByEtablissement(@Param("id") Long id);

    @Query("select u from Utilisateur u where u.isArchiver=false order by u.etat desc , u.date desc")
    public Optional<List<Utilisateur>> all();

    @Query("select u from Utilisateur u where u.compte.email=:email")
    public Optional<Utilisateur> findByEmail(@Param("email") String email);
}
