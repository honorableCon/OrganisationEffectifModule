package dev.honorablecon.rh.organisationEffectif.repository;

import dev.honorablecon.rh.organisationEffectif.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> { }
