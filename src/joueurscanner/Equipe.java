/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joueurscanner;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Formation
 */
public class Equipe implements Ressource {

    private String Nom;
    private List<Joueur> ListeJoueurs = new ArrayList<Joueur>();
    private String Jeux;

    public Equipe(String Nom, List<Joueur> ListeJoueurs) {
        this.Nom = Nom;
        this.ListeJoueurs = ListeJoueurs;
    }

    public String getNom() {
        return Nom;
    }

    public List<Joueur> getListeJoueurs() {
        return ListeJoueurs;
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
