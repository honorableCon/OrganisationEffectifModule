package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.repository.ContratRepository;
import dev.honorablecon.rh.organisationEffectif.repository.StatutRepository;
import dev.honorablecon.rh.organisationEffectif.repository.TypeContratRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChartsController {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    StatutRepository statutRepository;
    @Autowired
    TypeContratRepository typeContratRepository;
}
