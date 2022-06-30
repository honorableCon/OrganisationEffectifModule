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
    private String note;
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Cause cause;

    @OneToOne(fetch = FetchType.LAZY)
    private Personnel personnel;

    public Depart(Date dateDepart, Cause cause, Personnel personnel) {
        this.dateDepart = dateDepart;
        this.cause = cause;
        this.personnel = personnel;
    }

    public Depart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }
}
