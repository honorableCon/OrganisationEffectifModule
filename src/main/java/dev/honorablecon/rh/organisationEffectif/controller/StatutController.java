package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Statut;
import dev.honorablecon.rh.organisationEffectif.repository.StatutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class StatutController {
    @Autowired
    StatutRepository statutRepository;

    @QueryMapping(name = "statuts")
    public List<Statut> getAllStatuts(){
        return statutRepository.findAll();
    }

    @QueryMapping(name = "statutById")
    public Optional<Statut> getStatut(@Argument Long id){
        return statutRepository.findById(id);
    }

    @MutationMapping(name = "statut")
    public Statut addStatut(@Argument String libelle){
        Statut statut = new Statut(libelle);
        return statutRepository.save(statut);
    }
}
