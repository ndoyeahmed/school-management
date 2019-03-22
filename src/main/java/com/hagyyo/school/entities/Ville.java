package com.hagyyo.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ville;

    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "id")
    private Region region;

    @OneToMany(mappedBy = "ville")
    @JsonIgnore
    private List<Etablissement> etablissements;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }
}
