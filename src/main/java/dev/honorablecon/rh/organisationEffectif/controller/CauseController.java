package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Cause;
import dev.honorablecon.rh.organisationEffectif.repository.CauseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CauseController {
    @Autowired
    private CauseRepository causeRepository;

    @QueryMapping(name = "causes")
    public List<Cause> getAllCauses(){
        return causeRepository.findAll();
    }

    @QueryMapping(name = "causeById")
    public Cause getCause(@Argument Long id){
        return causeRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "cause")
    public Cause addCause(@Argument String libelle){
        Cause cause = new Cause(libelle);
        return causeRepository.save(cause);
    }
}
