package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Cause;
import dev.honorablecon.rh.organisationEffectif.model.Depart;
import dev.honorablecon.rh.organisationEffectif.model.Personnel;
import dev.honorablecon.rh.organisationEffectif.repository.CauseRepository;
import dev.honorablecon.rh.organisationEffectif.repository.DepartRepository;
import dev.honorablecon.rh.organisationEffectif.repository.PersonnelRepository;
import dev.honorablecon.rh.organisationEffectif.utils.DateMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class DepartController {
    @Autowired
    DepartRepository departRepository;
    @Autowired
    PersonnelRepository personnelRepository;
    @Autowired
    CauseRepository causeRepository;

    @QueryMapping(name = "departs")
    public List<Depart> getAllDeparts(){
        return departRepository.findAll();
    }

    @QueryMapping(name = "departById")
    public Depart getDepart(@Argument Long id){
        return departRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "depart")
    public Depart setDepart(@Argument DepartInput departInput) throws ParseException {
        Personnel personnel = personnelRepository.findById(departInput.personnelId)
                .orElseThrow();
        Cause cause = causeRepository.findById(departInput.causeId)
                .orElseThrow();
        Date dateDepart = DateMaker.strToDate(departInput.depart);
        Depart depart = new Depart(dateDepart, cause, personnel);

        return departRepository.save(depart);
    }

    record DepartInput(Long causeId, Long personnelId, String depart){};
}
