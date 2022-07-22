package dev.honorablecon.rh.organisationEffectif.model.statistiques;


import lombok.Getter;
import lombok.Setter;

public class Effectif {
    private Integer cdi;
    private Integer cdd;
    private Integer interim;
    private Integer stage;

    public Effectif(Integer cdi, Integer cdd, Integer interim, Integer stage) {
        this.cdi = cdi;
        this.cdd = cdd;
        this.interim = interim;
        this.stage = stage;
    }
}
