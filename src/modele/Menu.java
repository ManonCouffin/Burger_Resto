package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //attributs
    private List<Hamburger> listeHamburger = new ArrayList<>();
    private List<Boisson> listeBoisson = new ArrayList<>();
    private List<Accompagnement> listeAccompagnement = new ArrayList<>();

    //singleton
    private Menu(){}

    private static class MenuHolder{
        private final static Menu instance = new Menu();
    }

    public static Menu getInstance(){
        return MenuHolder.instance;
    }

    //methode
    public void ajouterAliment(Hamburger hamburger){
        if (!listeHamburger.contains(hamburger)){
            listeHamburger.add(hamburger);
        }
    }

    public void ajouterAliment(Accompagnement accompagnement){
        if (!listeAccompagnement.contains(accompagnement)){
            listeAccompagnement.add(accompagnement);
        }
    }

    public void ajouterAliment(Boisson boisson){
        if (!listeBoisson.contains(boisson)){
            listeBoisson.add(boisson);
        }
    }

    public List<Accompagnement> getListeAccompagnement() {
        return listeAccompagnement;
    }

    public List<Boisson> getListeBoisson() {
        return listeBoisson;
    }

    public List<Hamburger> getListeHamburger() {
        return listeHamburger;
    }

    public Hamburger choixHamburger(int numHamburger){
        return listeHamburger.get(numHamburger-1);
    }

    public Boisson choixBoisson(int numBoisson){
        return listeBoisson.get(numBoisson-1);
    }

    public Accompagnement choixAccompagnement(int numAccompagnement){
        return listeAccompagnement.get(numAccompagnement-1);
    }

    @Override
    public String toString() {
        return "Menu [" +
                "listeHamburger=" + listeHamburger +
                ", listeBoisson=" + listeBoisson +
                ", listeAccompagneent=" + listeAccompagnement +
                ']';
    }
}
