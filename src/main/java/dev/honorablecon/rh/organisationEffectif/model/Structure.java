package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "structure")
    @ToString.Exclude
    private List<Filiere> filieres;
}
