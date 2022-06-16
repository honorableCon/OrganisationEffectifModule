package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
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
    private Date debutIntegration;
    private Date finIntegration;
    private String libelle;

    @ManyToOne
    private Structure structure;
}
