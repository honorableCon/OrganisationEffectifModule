package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Depart;
import dev.honorablecon.rh.organisationEffectif.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DepartController {
    @Autowired
    DepartRepository departRepository;

    @QueryMapping(name = "departs")
    public List<Depart> getAllDeparts(){
        return departRepository.findAll();
    }

    @QueryMapping(name = "departById")
    public Depart getDepart(@Argument Long id){
        return departRepository.findById(id)
                .orElseThrow();
    }
}