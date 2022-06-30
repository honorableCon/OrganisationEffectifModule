package dev.honorablecon.rh.organisationEffectif.controller;

import dev.honorablecon.rh.organisationEffectif.model.*;
import dev.honorablecon.rh.organisationEffectif.repository.*;
import dev.honorablecon.rh.organisationEffectif.utils.DateMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class PersonnelController {
    @Autowired
    private PersonnelRepository personnelRepository;
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private FonctionRepository fonctionRepository;
    @Autowired
    private StatutRepository statutRepository;
    @Autowired
    private TypeContratRepository typeContratRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private IntegrationFiliereRepository integrationFiliereRepository;
    @Autowired
    private PersonnelFonctionRepository personnelFonctionRepository;

    @QueryMapping(name = "personnels")
    public List<Personnel> getAllPersonnels(){
        return personnelRepository.findAll();
    }

    @QueryMapping(name = "personnelById")
    public Personnel getPersonnel(@Argument Long id){
        return personnelRepository.findById(id)
                .orElseThrow();
    }

    @MutationMapping(name = "personnel")
    @Transactional()
    public Personnel setPersonnel(@Argument PersonnelInput personnelInput) throws ParseException {
        Date dateDebut = DateMaker.strToDate(personnelInput.dateDebut);
        Date dateFin = DateMaker.strToDate(personnelInput.dateFin);
        Statut statut = statutRepository.findById(personnelInput.statutId)
                                        .orElseThrow();
        Fonction fonction = fonctionRepository.findById(personnelInput.fonctionId)
                                              .orElseThrow();
        Filiere filiere = filiereRepository.findById(personnelInput.filiereId)
                                           .orElseThrow();
        TypeContrat typeContrat = typeContratRepository.findById(personnelInput.typeContratId)
                                                       .orElseThrow();

        Personnel personnel = new Personnel (
            personnelInput.prenom,
            personnelInput.nom,
            DateMaker.strToDate(personnelInput.dateDeNaissance),
            personnelInput.sexe,
            personnelInput.cni,
            personnelInput.nationalite,
            personnelInput.email,
            personnelInput.telephone,
            personnelInput.nombreConjoint,
            personnelInput.nombreEnfant
        );
        Personnel savedPersonnel = personnelRepository.save(personnel);

        Contrat contrat = new Contrat(dateDebut, dateFin, typeContrat, statut, savedPersonnel, true);
        IntegrationFiliere integrationFiliere = new IntegrationFiliere(dateDebut, dateFin, filiere, savedPersonnel,
                                                                       true);
        PersonnelFonction personnelFonction = new PersonnelFonction(dateDebut, dateFin, fonction, savedPersonnel);

        contratRepository.save(contrat);
        integrationFiliereRepository.save(integrationFiliere);
        personnelFonctionRepository.save(personnelFonction);

        return savedPersonnel;
    }


    record PersonnelInput(
        String prenom,
        String nom,
        String dateDeNaissance,
        String sexe,
        String cni,
        String nationalite,
        String email,
        String telephone,
        Integer nombreConjoint,
        Integer nombreEnfant,
        String dateDebut,
        String dateFin,
        Long statutId,
        Long typeContratId,
        Long fonctionId,
        Long filiereId
    ){}
}
