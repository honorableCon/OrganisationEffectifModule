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
    private Date naissance;
    @Column(length = 32)
    private String nationalite;
    @Column(length = 32)
    private String email;
    @Column(length = 16)
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
