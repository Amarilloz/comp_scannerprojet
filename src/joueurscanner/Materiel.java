/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joueurscanner;

import java.awt.Color;

/**
 *
 * @author Formation
 */
public class Materiel implements Ressource {

    private String NomDuMateriel;
    private String Jeux;

    public Materiel(String NomDuMateriel) {
        this.NomDuMateriel = NomDuMateriel;
    }

    public String getNomDuMateriel() {
        return NomDuMateriel;
    }

    @Override
    public String getJeux() {
        return Jeux;
    }

    @Override
    public void setJeux(String jeux) {
        this.Jeux = jeux;
    }

    @Override
    public Color getCouleur() {
        return Color.BLACK;
    }

}
