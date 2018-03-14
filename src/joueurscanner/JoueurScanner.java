/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joueurscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class JoueurScanner {

    private static Scanner sc = new Scanner(System.in);
    private static List<JoueurFootball> listeJoueursF = new ArrayList<JoueurFootball>();
    private static List<JoueurRugby> listeJoueursR = new ArrayList<JoueurRugby>();
    private static List<JoueurHandball> listeJoueursH = new ArrayList<JoueurHandball>();

    public JoueurScanner() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            int nbJoueur = 0;
            int typeJoueur = 0;
            String valeur = "";
            List<Joueur> listeJoueurs = new ArrayList<Joueur>();

            System.out.println("Saisir un nombre :");
            while (!sc.hasNextInt()) {
                sc.next();
            }
            valeur = sc.next();
            nbJoueur = Integer.parseInt(valeur);// Transforme un String en Integer
            if (nbJoueur != 0) {
                do {
                    System.out.println("Saisir le type de joueur :"
                            + "\n\t1 : Football"
                            + "\n\t2 : Rugby"
                            + "\n\t3 : Handball"
                            + "\n0 : FIN");
                    while (!sc.hasNextInt()) {
                        System.out.println("Saisir le type de joueur :"
                                + "\n\t1 : Football"
                                + "\n\t2 : Rugby"
                                + "\n\t3 : Handball"
                                + "\n 0 : FIN");
                        sc.next();
                    }
                    valeur = sc.next();
                    typeJoueur = Integer.parseInt(valeur);

                    // Nombre de Joueur OK
//                while (listeJoueurs.size() < nbJoueur) {
                    if (typeJoueur != 0) {
                        switch (typeJoueur) {
                            case 1:
                                saisir_joueur(listeJoueurs, new JoueurFootball());
                                break;
                            case 2:
                                saisir_joueur(listeJoueurs, new JoueurRugby());
                                break;
                            case 3:
                                saisir_joueur(listeJoueurs, new JoueurHandball());
                                break;
                            default:
                                break;
                        }
                    } else {
                        nbJoueur--;
                    }
//                saisir_joueur(listeJoueurs, new Joueur());
//                }
                } while (listeJoueurs.size() < nbJoueur);
                trierEquipes(listeJoueurs);
            }
            System.out.println("-------------FIN-------------");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param listeJoueurs
     * <b>Toutes les exceptions seront gérées dans le main.</b>
     * <i>On saisit toutes les données du joueur et on contrôle la saisie</i>
     * @throws Exception
     */
    public static void saisir_joueur(List<Joueur> listeJoueurs, Joueur oJ) throws Exception {

        String temp = "";
        int valtemp = 0;
        int tentative = 1;
//        Joueur oJ = new Joueur();

        System.out.println("Joueur : " + oJ.getClass().getName());

        System.out.println("Saisir le nom :");
        oJ.setNom(setClavier(temp));

        System.out.println("Saisir le prenom :");
        oJ.setPrenom(setClavier(temp));

        System.out.println("Saisir l'age :");
        tentative = 3;
        do {
            valtemp = setClavier(valtemp);
            if (valtemp >= 12) {
                oJ.setAge(valtemp);
            }
            if (valtemp < 12) {
                if (tentative > 1) {
                    System.out.println("L'âge est inférieur à 12 !");
                    System.out.println("Saisir l'age :");
                    tentative--;
                } else {
                    tentative--;
                }
            }
            if (tentative == 0) {
                throw new Exception("L'âge est inférieur à 12 !");
            }
        } while (valtemp < 12);

        System.out.println("Saisir le surnom :");
        oJ.setPseudo(setClavier(temp));

        System.out.println("Saisir le mot de passe :");
        tentative = 3;
        do {
            temp = setClavier(temp);
            if (temp.length() >= 2) {
                oJ.setMdp(temp);
            }
            if (temp.length() < 2) {
                if (tentative > 1) {
                    System.out.println("La taille du mot de passe est inférieure à 2 !");
                    System.out.println("Saisir le mot de passe :");
                    tentative--;
                } else {
                    tentative--;
                }
            }
            if (tentative == 0) {
                throw new Exception("La taille du mot de passe est inférieure à 2 !");
            }
        } while (temp.length() < 2);

        System.out.println("Saisir le genre :");
        tentative = 3;
        do {
            temp = setClavier(temp);
            if (temp.equalsIgnoreCase("M") || temp.equalsIgnoreCase("H")
                    || temp.equalsIgnoreCase("Homme")) {
                oJ.setGenre(Genre.Homme);
            }
            if (temp.equalsIgnoreCase("F") || temp.equalsIgnoreCase("Femme")) {
                oJ.setGenre(Genre.Femme);
            }
            if (!temp.equalsIgnoreCase("M") && !temp.equalsIgnoreCase("H")
                    && !temp.equalsIgnoreCase("Homme")
                    && !temp.equalsIgnoreCase("F")
                    && !temp.equalsIgnoreCase("Femme")) {
                if (tentative > 1) {
                    System.out.println("Le genre est invalide !");
                    System.out.println("Saisir le genre :");
                    tentative--;
                } else {
                    tentative--;
                }
            }
            if (tentative == 0) {
                throw new Exception("Le genre est invalide !");
            }
        } while (!temp.equalsIgnoreCase("M") && !temp.equalsIgnoreCase("H") && !temp.equalsIgnoreCase("Homme")
                && !temp.equalsIgnoreCase("F") && !temp.equalsIgnoreCase("Femme"));

        listeJoueurs.add(oJ);
    }

    public static String setClavier(String temp) {
        temp = sc.next();
        return temp;
    }

    public static int setClavier(int temp) {
        if (sc.hasNext()) {
            temp = sc.nextInt();
        }
        return temp;
    }

    //Méthode des Listes
    public static void trierEquipes(List<Joueur> listeJoueurs) {
        //Je veux une boucle qui remplie 3 listes selon le type de Joueur
        //for each
        for (Joueur oJ : listeJoueurs) {
            //si avec instanceof de chaque type
            if (oJ instanceof JoueurFootball) {
                listeJoueursF.add((JoueurFootball) oJ);
            }
            if (oJ instanceof JoueurRugby) {
                listeJoueursR.add((JoueurRugby) oJ);
            }
            if (oJ instanceof JoueurHandball) {
                listeJoueursH.add((JoueurHandball) oJ);
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Equipe de Football");
        System.out.println("-----------------------------");
        System.out.println("");
        for (Joueur oJ : listeJoueursF) {
            System.out.println("Nom \t: " + oJ.getNom()
                    + "\nPrenom \t: " + oJ.getPrenom()
                    + "\nSurnom \t: " + oJ.getPseudo()
                    + "\nAge \t: " + oJ.getAge()
                    + "\nSexe \t: " + oJ.getGenre());
            System.out.println("");
        }
        System.out.println("-----------------------------");
        System.out.println("Equipe de Rugby");
        System.out.println("-----------------------------");
        System.out.println("");
        for (Joueur oJ : listeJoueursR) {
            System.out.println("Nom \t: " + oJ.getNom()
                    + "\nPrenom \t: " + oJ.getPrenom()
                    + "\nSurnom \t: " + oJ.getPseudo()
                    + "\nAge \t: " + oJ.getAge()
                    + "\nSexe \t: " + oJ.getGenre());
            System.out.println("");
        }
        System.out.println("-----------------------------");
        System.out.println("Equipe de Handball");
        System.out.println("-----------------------------");
        System.out.println("");
        for (Joueur oJ : listeJoueursH) {
            System.out.println("Nom \t: " + oJ.getNom()
                    + "\nPrenom \t: " + oJ.getPrenom()
                    + "\nSurnom \t: " + oJ.getPseudo()
                    + "\nAge \t: " + oJ.getAge()
                    + "\nSexe \t: " + oJ.getGenre());
            System.out.println("");
        }
        System.out.println("-----------------------------");
    }
}
