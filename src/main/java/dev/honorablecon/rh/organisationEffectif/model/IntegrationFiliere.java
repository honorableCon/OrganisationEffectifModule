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
    @Temporal(TemporalType.DATE)
    private Date debutIntegration;
    @Temporal(TemporalType.DATE)
    private Date finIntegration;

    @ManyToOne(fetch = FetchType.LAZY)
    private Personnel personnel;

    @ManyToOne(fetch = FetchType.LAZY)
    private Filiere filiere;
}
