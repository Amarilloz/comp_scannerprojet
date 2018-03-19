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
public class Joueur implements Ressource {

    private String nom;
    private String prenom;
    private int age;
    private String pseudo;
    private String mdp;
    private Genre genre;
    private String Jeux;

    public Joueur(String nom, String prenom, int age, String pseudo, String mdp, Genre genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.genre = genre;
    }

    public Joueur() {
        this.nom = "";
        this.prenom = "";
        this.age = 0;
        this.pseudo = "";
        this.mdp = "";
        this.genre = Genre.HOMME;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
