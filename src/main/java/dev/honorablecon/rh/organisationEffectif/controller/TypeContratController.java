package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.TypeContrat;
import dev.honorablecon.rh.organisationEffectif.repository.TypeContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TypeContratController {
    @Autowired
    TypeContratRepository typeContratRepository;

    @QueryMapping(name = "typeContrats")
    public List<TypeContrat> getAllTypeContrats(){
        return typeContratRepository.findAll();
    }

    @QueryMapping(name = "typeContratById")
    public Optional<TypeContrat> getTypeContrat(@Argument Long id){
        return typeContratRepository.findById(id);
    }

    @MutationMapping(name = "typeContrat")
    public TypeContrat addTypeContrat(@Argument String libelle){
        TypeContrat typeContrat = new TypeContrat(libelle);
        return typeContratRepository.save(typeContrat);
    }
}
