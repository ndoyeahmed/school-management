package com.hagyyo.school;

import com.hagyyo.school.entities.Compte;
import com.hagyyo.school.entities.Utilisateur;
import com.hagyyo.school.services.CompteService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchoolManagementApplication extends SpringBootServletInitializer {

    @Autowired
    private CompteService service;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SchoolManagementApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementApplication.class, args);
    }

    @Bean
    InitializingBean compte() {
        return () -> {
            try {
                Utilisateur u = new Utilisateur();
                u.setId(1L);
                u.setEtat(true);
                u.setNom("NDOYE");
                u.setPrenom("Mouhamed");
                u.setTelephone("774315331");
                u.setAdresse("Ouakam");
                String profil = "Super Administrateur";
                Compte compte = new Compte();
                compte.setId(1L);
                compte.setEmail("billeteriegestion@gmail.com");
                service.addUser(u, profil, compte,false, null);
            } catch (Exception e) { e.printStackTrace(); }
        };
    }
}
