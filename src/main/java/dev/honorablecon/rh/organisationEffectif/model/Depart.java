package dev.honorablecon.rh.organisationEffectif.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Cause cause;

    @OneToOne
    private Personnel personnel;
}
