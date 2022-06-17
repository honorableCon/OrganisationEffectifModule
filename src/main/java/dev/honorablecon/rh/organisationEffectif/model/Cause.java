package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cause {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "cause")
    @ToString.Exclude
    private List<Depart> departs;

    public Cause(String libelle) {
        this.libelle = libelle;
    }
}
