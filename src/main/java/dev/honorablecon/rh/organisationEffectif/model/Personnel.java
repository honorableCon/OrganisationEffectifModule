package dev.honorablecon.rh.organisationEffectif.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String sexe;
    private Date naissance;
    private String nationalite;
    private String email;
    private String telephone;
    private Integer nombreConjoint;
    private Integer nombreEnfant;

    @ManyToOne(fetch = FetchType.LAZY)
    private Filiere filiere;

    @OneToMany(mappedBy = "personnel")
    private List<PersonnelFonction> personnelFonctions;

    @OneToMany(mappedBy = "personnel")
    private List<Contrat> contrats;
}
