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
    @Temporal(TemporalType.DATE)
    private Date debutIntegration;
    @Temporal(TemporalType.DATE)
    private Date finIntegration;
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Structure structure;

    @OneToMany(mappedBy = "filiere")
    @ToString.Exclude
    private List<Personnel> personnels;
}
