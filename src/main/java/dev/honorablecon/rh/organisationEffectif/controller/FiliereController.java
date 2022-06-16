package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Filiere;
import dev.honorablecon.rh.organisationEffectif.repository.FiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FiliereController {
    @Autowired
    FiliereRepository filiereRepository;

    @QueryMapping(name = "filieres")
    public List<Filiere> getAllFilieres(){
        return filiereRepository.findAll();
    }

    @QueryMapping(name = "filiereById")
    public Filiere getFiliere(@Argument Long id){
        return filiereRepository.findById(id)
                .orElseThrow();
    }
}
