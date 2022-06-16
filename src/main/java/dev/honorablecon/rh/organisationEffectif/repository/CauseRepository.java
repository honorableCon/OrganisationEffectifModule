package dev.honorablecon.rh.organisationEffectif.repository;

import dev.honorablecon.rh.organisationEffectif.model.Cause;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CauseRepository extends JpaRepository<Cause, Long> {
}
