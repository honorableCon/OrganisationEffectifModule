package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonnelFonction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date debutFonction;
    private Date finFonction;

    @ManyToOne(fetch = FetchType.LAZY)
    private Fonction fonction;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personnel personnel;
}
