package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    @ToString.Exclude
    private Filiere filiere;

    @OneToMany(mappedBy = "personnel")
    @ToString.Exclude
    private List<PersonnelFonction> personnelFonctions;

    @OneToMany(mappedBy = "personnel")
    @ToString.Exclude
    private List<Contrat> contrats;

    @OneToOne(mappedBy = "personnel")
    private Depart depart;
}
