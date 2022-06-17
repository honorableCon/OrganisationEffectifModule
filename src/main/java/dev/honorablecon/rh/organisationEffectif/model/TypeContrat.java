package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TypeContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 32)
    private String libelle;

    public TypeContrat(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "typeContrat")
    @ToString.Exclude
    List<Contrat> contrats;
}
