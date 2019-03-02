package com.hagyyo.school.security;

import com.hagyyo.school.entities.Utilisateur;
import com.hagyyo.school.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Utilisateur> userSearch = repository.connexion(login, true);
        return userSearch.map(utilisateur -> {
            List<GrantedAuthority> profils = utilisateur.getProfilUtilisateurs().stream().map(x ->
                new SimpleGrantedAuthority(x.getProfil().getNom())
            ).collect(Collectors.toList());
            return new User(login, utilisateur.getCompte().getPassword(), profils);
        }).orElseThrow(() -> new UsernameNotFoundException("L'utilisateur " + login + " n'existe pas !"));
    }
}
