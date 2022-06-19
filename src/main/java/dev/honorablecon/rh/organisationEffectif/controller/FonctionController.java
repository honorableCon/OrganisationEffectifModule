package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.Fonction;
import dev.honorablecon.rh.organisationEffectif.repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FonctionController {
    @Autowired
    private FonctionRepository fonctionRepository;

    @QueryMapping(name = "fonctions")
    public List<Fonction> getAllFonctions(){
        return fonctionRepository.findAll();
    }

    @QueryMapping(name = "fonctionById")
    public Fonction getFonction(@Argument Long id){
        return fonctionRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "fonction")
    public Fonction setFonction(@Argument String libelle){
        Fonction fonction =  new Fonction(libelle);

        return fonctionRepository.save(fonction);
    }
}
