package dev.honorablecon.rh.organisationEffectif.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class IntegrationFiliere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean etat;
    @Temporal(TemporalType.DATE)
    private Date debutIntegration;
    @Temporal(TemporalType.DATE)
    private Date finIntegration;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Personnel personnel;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Filiere filiere;

    public IntegrationFiliere(Date debutIntegration, Date finIntegration, Personnel personnel, Filiere filiere) {
        this.debutIntegration = debutIntegration;
        this.finIntegration = finIntegration;
        this.personnel = personnel;
        this.filiere = filiere;
    }

    public IntegrationFiliere(Date dateDebut, Date dateFin, Filiere filiere, Personnel personnel, boolean etat) {
        this.debutIntegration = dateDebut;
        this.finIntegration = dateFin;
        this.filiere = filiere;
        this.personnel = personnel;
        this.etat = etat;
    }

    public IntegrationFiliere(Date dateDebut, Date dateFin, Filiere filiere, boolean b) {
        this.debutIntegration = dateDebut;
        this.finIntegration = dateFin;
        this.filiere = filiere;
        this.etat = b;
    }

}
