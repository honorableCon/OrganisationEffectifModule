package dev.honorablecon.rh.organisationEffectif.repository;

import dev.honorablecon.rh.organisationEffectif.model.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Depart, Long> {
}
