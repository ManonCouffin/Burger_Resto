package vueConsole;
/*
    Créateur du fichier : Manon COUFFIN
*/

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierClient {
    //attributs
    private ControlSIdentifier controlSIdentifier;

    //constructeur
    public BoundarySIdentifierClient(ControlSIdentifier c){
        controlSIdentifier = c;
    }

    //methodes
    public int sIdentifierClient(){

        System.out.println("Veuillez entrez votre login");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre mdp");
        String mdp = Clavier.entrerClavierString();

        int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT,login,mdp);

        return numClient;
    }
}
