package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.*;

import java.util.ArrayList;
import java.util.List;

public class ControlCommander {
    //attributs
    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();
    private BDClient bdClient = BDClient.getInstance();
    private BDCommande bdCommande = BDCommande.getInstance();

    //constructeur
    public ControlCommander(ControlVerifierIdentification controlVerifierIdentification){
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    //methodes
    public boolean verifierIdentification(int numClient){
        return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT,numClient);
    }

    public List<String> donnerListeHamburger(){
        List<String> listeNomHamburger = new ArrayList<>();
        List<Hamburger> listeHamburger = menu.getListeHamburger();
        for (Hamburger hamb : listeHamburger){
            listeNomHamburger.add(hamb.getNom());
        }
        return listeNomHamburger;
    }

    public List<String> donnerListeAccompagnement(){
        List<String> listeNomAccompagnement = new ArrayList<>();
        List<Accompagnement> listeAccompagnement = menu.getListeAccompagnement();
        for (Accompagnement accompagnement : listeAccompagnement){
            listeNomAccompagnement.add(accompagnement.getNom());
        }
        return listeNomAccompagnement;
    }

    public List<String> donnerListeBoisson(){
        List<String> listeNomBoisson = new ArrayList<>();
        List<Boisson> listeBoisson = menu.getListeBoisson();
        for (Boisson boisson : listeBoisson){
            listeNomBoisson.add(boisson.getNom());
        }
        return listeNomBoisson;
    }

    public boolean verifierExistenceCarteBancaire(int numClient){
        Client client = bdClient.trouverClient(numClient);
        if (client != null) {
            return client.verifierExistenceCarteBancaire();
        }
        return false;
    }

    public int enregistrerCommande(int numClient, int numHamburger, int numAccompagnement, int numBoisson){
        Hamburger hamburger = menu.choixHamburger(numHamburger);
        Accompagnement accompagnement = menu.choixAccompagnement(numAccompagnement);
        Boisson boisson = menu.choixBoisson(numBoisson);
        return bdCommande.enregistrerCommande(numClient,hamburger,accompagnement,boisson);
    }
}
