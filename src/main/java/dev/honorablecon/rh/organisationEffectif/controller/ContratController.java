package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Contrat;
import dev.honorablecon.rh.organisationEffectif.model.Statut;
import dev.honorablecon.rh.organisationEffectif.model.TypeContrat;
import dev.honorablecon.rh.organisationEffectif.repository.ContratRepository;
import dev.honorablecon.rh.organisationEffectif.repository.StatutRepository;
import dev.honorablecon.rh.organisationEffectif.repository.TypeContratRepository;
import dev.honorablecon.rh.organisationEffectif.utils.DateMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ContratController {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    StatutRepository statutRepository;
    @Autowired
    TypeContratRepository typeContratRepository;


    @QueryMapping(name="contrats")
    public List<Contrat> getAllContrats(){
        return contratRepository.findAll();
    }

    @QueryMapping(name = "contratById")
    public Optional<Contrat> getContrat(@Argument Long id){
        return contratRepository.findById(id);
    }

    @QueryMapping(name = "contratsByDate")
    public List<Contrat> getAllContratsInDate(@Argument String date) throws ParseException {
        Date debutContrat = DateMaker.strToDate(date+"-01-01");

        return contratRepository.findByDebutContratBetween(debutContrat, DateMaker.addOneYear(debutContrat));
    }

    @MutationMapping(name="contrat")
    public Contrat setContrat(@Argument ContratInput contratFields) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Statut statut = statutRepository.findById(contratFields.statutId).orElseThrow();
        TypeContrat typeContrat = typeContratRepository.findById(contratFields.typeContratId).orElseThrow();
        Date debutContrat = formatter.parse(contratFields.debut);
        Date finContrat = formatter.parse(contratFields.fin);

        Contrat contrat = new Contrat(debutContrat, finContrat, typeContrat, statut, true);

        return contratRepository.save(contrat);
    }

    record ContratInput(Long statutId, Long typeContratId, String debut, String fin){};
}
