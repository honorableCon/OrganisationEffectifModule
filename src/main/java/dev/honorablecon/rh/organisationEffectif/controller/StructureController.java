package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Structure;
import dev.honorablecon.rh.organisationEffectif.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StructureController {
    @Autowired
    StructureRepository structureRepository;

    @QueryMapping(name = "structures")
    public List<Structure> getAllStructures(){
        return structureRepository.findAll();
    }

    @QueryMapping(name = "structureById")
    public Structure getStructure(@Argument Long id){
        return structureRepository.findById(id)
                .orElseThrow();
    }
}
