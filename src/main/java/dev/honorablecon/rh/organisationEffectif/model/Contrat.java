package dev.honorablecon.rh.organisationEffectif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean etat;
    @Temporal(TemporalType.DATE)
    private Date debutContrat;
    @Temporal(TemporalType.DATE)
    private Date finContrat;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private TypeContrat typeContrat;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Statut statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Personnel personnel;

    public Contrat(Date debutContrat, Date finContrat, TypeContrat typeContrat, Statut statut, Boolean etat) {
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
        this.typeContrat = typeContrat;
        this.statut = statut;
        this.etat = etat;
    }

    public Contrat(Date dateDebut, Date dateFin, TypeContrat typeContrat, Statut statut, Personnel personnel,
                   Boolean etat) {
        this.debutContrat = dateDebut;
        this.finContrat = dateFin;
        this.typeContrat = typeContrat;
        this.statut = statut;
        this.personnel = personnel;
        this.etat = etat;
    }
}
