package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 32)
    private String libelle;

    @OneToMany(mappedBy = "fonction")
    @ToString.Exclude
    private List<PersonnelFonction> personnelFonctions;

    public Fonction(String libelle){ this.libelle = libelle;}
}
