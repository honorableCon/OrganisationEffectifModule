package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Fonction;
import dev.honorablecon.rh.organisationEffectif.model.Personnel;
import dev.honorablecon.rh.organisationEffectif.model.PersonnelFonction;
import dev.honorablecon.rh.organisationEffectif.repository.FonctionRepository;
import dev.honorablecon.rh.organisationEffectif.repository.PersonnelFonctionRepository;
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
public class PersonnelFonctionController {
    @Autowired
    PersonnelFonctionRepository personnelFonctionRepository;
    @Autowired
    FonctionRepository fonctionRepository;
    @Autowired
    PersonnelRepository personnelRepository;

    @QueryMapping(name = "personnelFonctions")
    public List<PersonnelFonction> getAllPersonnelFonctions(){
        return personnelFonctionRepository.findAll();
    }

    @QueryMapping(name = "personnelFonctionById")
    public PersonnelFonction getPersonnelFonction(@Argument Long id){
        return personnelFonctionRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "personnelFonction")
    public PersonnelFonction getPersonnelFonction(@Argument PersonnelFonctionInput personnelFonctionInput) throws ParseException {
        Fonction fonction = fonctionRepository.findById(personnelFonctionInput.fonctionId)
                .orElseThrow();
        Personnel personnel = personnelRepository.findById(personnelFonctionInput.personnelId)
                .orElseThrow();
        Date debutFonction = DateMaker.strToDate(personnelFonctionInput.debutFonction);
        Date finFonction = DateMaker.strToDate(personnelFonctionInput.finFonction);
        PersonnelFonction personnelFonction = new PersonnelFonction(debutFonction, finFonction, fonction);

        return personnelFonctionRepository.save(personnelFonction);
    }

    record PersonnelFonctionInput(String debutFonction, String finFonction, Long fonctionId, Long personnelId){};
}
