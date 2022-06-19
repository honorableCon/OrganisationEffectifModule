package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Structure structure;

//record FiliereInput(String libelle, Long structureId){};
    @OneToMany(mappedBy = "filiere")
    private List<IntegrationFiliere> integrationFilieres;


}

