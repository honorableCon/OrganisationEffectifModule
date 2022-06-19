package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Filiere;
import dev.honorablecon.rh.organisationEffectif.model.Structure;
import dev.honorablecon.rh.organisationEffectif.repository.FiliereRepository;
import dev.honorablecon.rh.organisationEffectif.repository.StructureRepository;
import dev.honorablecon.rh.organisationEffectif.utils.DateMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class FiliereController {
    @Autowired
    FiliereRepository filiereRepository;
    @Autowired
    StructureRepository structureRepository;

    @QueryMapping(name = "filieres")
    public List<Filiere> getAllFilieres(){
        return filiereRepository.findAll();
    }

    @QueryMapping(name = "filiereById")
    public Filiere getFiliere(@Argument Long id){
        return filiereRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "filiere")
    public Filiere setFiliere(@Argument FiliereInput filiereInput){
        Structure structure = structureRepository.findById(filiereInput.structureId)
                .orElseThrow();
        Filiere filiere = new Filiere();
        filiere.setStructure(structure);
        filiere.setLibelle(filiereInput.libelle);

        return filiereRepository.save(filiere);
    }

    record FiliereInput(String libelle, Long structureId){};
}
