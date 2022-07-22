package dev.honorablecon.rh.organisationEffectif.repository;

import dev.honorablecon.rh.organisationEffectif.model.Contrat;
import dev.honorablecon.rh.organisationEffectif.model.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
/*
    List<Contrat> findByDebutContrat(Date debutContrat);
*/

    List<Contrat> findByDebutContratStartingWith(Date debutContrat);

    List<Contrat> findByDebutContrat(Date debutContrat);

    List<Contrat> findByDebutContratAfter(Date debutContrat);


    List<Contrat> findByDebutContratBetween(Date debutContrat, Date addOneYear);

    List<Contrat> findByTypeContratLibelle(String libelle);

    List<Contrat> findByDebutContratAndTypeContratLibelle(Date debutContrat, String cdi);

    List<Contrat> findByDebutContratBetweenAndTypeContratLibelle(Date debutContrat, Date finContrat, String libelle);
}
