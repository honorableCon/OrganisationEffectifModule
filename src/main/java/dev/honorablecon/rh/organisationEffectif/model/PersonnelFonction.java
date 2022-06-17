package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonnelFonction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date debutFonction;
    @Temporal(TemporalType.DATE)
    private Date finFonction;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Fonction fonction;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Personnel personnel;
}
