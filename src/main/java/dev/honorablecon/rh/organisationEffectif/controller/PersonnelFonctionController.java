package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.PersonnelFonction;
import dev.honorablecon.rh.organisationEffectif.repository.PersonnelFonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonnelFonctionController {
    @Autowired
    PersonnelFonctionRepository personnelFonctionRepository;

    @QueryMapping(name = "personnelFonctions")
    public List<PersonnelFonction> getAllPersonnelFonctions(){
        return personnelFonctionRepository.findAll();
    }

    @QueryMapping(name = "personnelFonctionById")
    public PersonnelFonction getPersonnelFonction(@Argument Long id){
        return personnelFonctionRepository.findById(id)
                .orElseThrow();
    }
}
