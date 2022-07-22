package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.statistiques.Effectif;
import dev.honorablecon.rh.organisationEffectif.repository.ContratRepository;
import dev.honorablecon.rh.organisationEffectif.repository.StatutRepository;
import dev.honorablecon.rh.organisationEffectif.repository.TypeContratRepository;
import dev.honorablecon.rh.organisationEffectif.utils.DateMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Date;

@Controller
public class StatistiqueController {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    StatutRepository statutRepository;
    @Autowired
    TypeContratRepository typeContratRepository;

    @QueryMapping(name = "effectifEmploye")
    public Effectif getAllEffectif(@Argument String date) throws ParseException {
        Date debutContrat = DateMaker.strToDate(date + "-01-01");

        Integer cdi = contratRepository.findByDebutContratBetweenAndTypeContratLibelle(debutContrat, DateMaker.addOneYear(debutContrat), "CDI")
                                       .size();
        Integer cdd = contratRepository.findByDebutContratBetweenAndTypeContratLibelle(debutContrat, DateMaker.addOneYear(debutContrat), "CDD")
                                       .size();
        Integer interim = contratRepository.findByDebutContratBetweenAndTypeContratLibelle(debutContrat,
                                                                                           DateMaker.addOneYear(debutContrat), "Interimaire")
                                       .size();
        Integer stage = contratRepository.findByDebutContratBetweenAndTypeContratLibelle(debutContrat, DateMaker.addOneYear(debutContrat), "Stage")
                                         .size();

        return new Effectif(cdd, cdi, interim, stage);
    }
}
