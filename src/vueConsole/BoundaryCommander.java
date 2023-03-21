package vueConsole;
/*
    Créateur du fichier : Manon COUFFIN
*/

import controleur.ControlCommander;

import java.util.List;

public class BoundaryCommander {
    //attributs
    private ControlCommander controlCommander;
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerDonneBanquaire;

    //constructeur
    public BoundaryCommander(ControlCommander controlCommander, BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires){
        this.controlCommander = controlCommander;
        this.boundaryEnregistrerDonneBanquaire = boundaryEnregistrerCoordonneesBancaires;
    }

    //methodes
    public void commander(int numClient){
        if (controlCommander.verifierIdentification(numClient)){

            int numHamburger = selectionnerBurger();

            int numAccompagnement = selectionnerAccompagnement();

            int numBoisson = selectionnerBoisson();

            boolean carteRenseigne = controlCommander.verifierExistenceCarteBancaire(numClient);
            if (!carteRenseigne){
                carteRenseigne = boundaryEnregistrerDonneBanquaire.enregistrerCoordonneesBancaires(numClient);
            }

            if (carteRenseigne){
                int numCommande = controlCommander.enregistrerCommande(numClient,numHamburger,numAccompagnement,numBoisson);
                System.out.println("Votre numero de commande est le : " + numCommande);
            }
            else {
                System.out.println("ERREUR, votre catre n'est pas renseigné");
            }
        }
    }

    private int selectionnerBurger(){
        List<String> listeHamburger = controlCommander.donnerListeHamburger();
        System.out.println("Veuillez selectionner le numero de votre Hamburger");
        int nb = 1;
        for (String nomHamb : listeHamburger){
            System.out.println("-" + nb + " " + nomHamb);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

    private int selectionnerAccompagnement(){
        List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
        System.out.println("Veuillez selectionner le numero de votre accompagnement : ");
        int nb = 1;
        for (String nomAcc : listeAccompagnement){
            System.out.println("-" + nb + " " + nomAcc);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

    private int selectionnerBoisson(){
        List<String> listeBoisson = controlCommander.donnerListeBoisson();
        System.out.println("Veuillez selectionner le numero de votre boisson : ");
        int nb = 1;
        for (String nomBoisson : listeBoisson){
            System.out.println("-" + nb + " " + nomBoisson);
            nb++;
        }
        return Clavier.entrerClavierInt();
    }

}
