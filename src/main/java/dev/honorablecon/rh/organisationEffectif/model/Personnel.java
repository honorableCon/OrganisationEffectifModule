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
    @Column(length = 16)
    private String cni;
    @Column(length = 64)
    private String prenom;
    @Column(length = 32)
    private String nom;
    @Column(length = 8)
    private String sexe;
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    @Column(length = 32)
    private String nationalite;
    @Column(length = 32)
    private String email;
    @Column(length = 16)
    private String telephone;
    private Integer nombreConjoint;
    private Integer nombreEnfant;
    private Boolean deleted;

    @OneToMany(mappedBy = "personnel")
    @ToString.Exclude
    private List<PersonnelFonction> personnelFonctions;

    @OneToMany(mappedBy = "personnel")
    @ToString.Exclude
    private List<Contrat> contrats;

    @OneToOne(mappedBy = "personnel")
    private Depart depart;

    @OneToMany(mappedBy = "personnel")
    @ToString.Exclude
    private List<IntegrationFiliere> integrationFilieres;

    public Personnel(Long id, String cni, String prenom, String nom, String sexe, Date dateDeNaissance, String nationalite, String email, String telephone, Integer nombreConjoint, Integer nombreEnfant) {
        this.id = id;
        this.cni = cni;
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.email = email;
        this.telephone = telephone;
        this.nombreConjoint = nombreConjoint;
        this.nombreEnfant = nombreEnfant;
        this.deleted = false;
    }

    public Personnel(String prenom, String nom, String sexe, String cni, String nationalite, String email, String telephone, Integer nombreConjoint, Integer nombreEnfant) {
        this.prenom = prenom;
        this.nom = nom;
        this.sexe = sexe;
        this.cni = cni;
        this.nationalite = nationalite;
        this.email = email;
        this.telephone = telephone;
        this.nombreConjoint = nombreConjoint;
        this.nombreEnfant = nombreEnfant;
        this.deleted = false;
    }

    public Personnel(String prenom, String nom, Date dateDeNaissance, String sexe, String cni, String nationalite, String email, String telephone, Integer nombreConjoint, Integer nombreEnfant) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.cni = cni;
        this.nationalite = nationalite;
        this.email = email;
        this.telephone = telephone;
        this.nombreConjoint = nombreConjoint;
        this.nombreEnfant = nombreEnfant;
        this.deleted = false;
    }
}
