package vueConsole;
/*
    Créateur du fichier : Manon COUFFIN
*/

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {
    //attributs
    private ControlSIdentifier controlSIdentifier;

    //constructeur
    public BoundarySIdentifierPersonnel(ControlSIdentifier c){
        controlSIdentifier = c;
    }

    //methodes
    public int sIdentifierPersonnel(){

        System.out.println("Veuillez entrez votre login :");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuillez entrez votre mdp :");
        String mdp = Clavier.entrerClavierString();

        controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL,login,mdp);

        return 0;
    }

}
