package dev.honorablecon.rh.organisationEffectif.model.input;

            public record PersonnelInput(
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
            ){
            }
