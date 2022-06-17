package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Personnel;
import dev.honorablecon.rh.organisationEffectif.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonnelController {
    @Autowired
    private PersonnelRepository personnelRepository;

    @QueryMapping(name = "personnels")
    public List<Personnel> getAllPersonnels(){
        return personnelRepository.findAll();
    }

    @QueryMapping(name = "personnelById")
    public Personnel getPersonnel(@Argument Long id){
        return personnelRepository.findById(id)
                .orElseThrow();
    }
}
