package dev.honorablecon.rh.organisationEffectif.repository;

import dev.honorablecon.rh.organisationEffectif.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
}
