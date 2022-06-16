package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

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
