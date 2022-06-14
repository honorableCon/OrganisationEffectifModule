package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    public Statut(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "statut")
    @ToString.Exclude
    List<Contrat> contrats;
}
