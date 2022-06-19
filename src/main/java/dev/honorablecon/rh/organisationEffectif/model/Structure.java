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
    @Column(length = 64)
    private String libelle;

    @OneToMany(mappedBy = "structure")
    @ToString.Exclude
    private List<Filiere> filieres;

    public Structure(String libelle){
        this.libelle = libelle;
    }
}
