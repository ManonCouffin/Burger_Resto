package vueConsole;
/*
    Créateur du fichier : Manon COUFFIN
*/

import controleur.ControlEnregistrerCoordonneesBancaires;

public class BoundaryEnregistrerCoordonneesBancaires {
    //attributs
    private ControlEnregistrerCoordonneesBancaires controlEnregisterDonneBanquaire;

    //constructeur
    public BoundaryEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires c){
        controlEnregisterDonneBanquaire = c;
    }

    //methodes
    public boolean enregistrerCoordonneesBancaires(int numClient){
        System.out.println("Veuillez entrer votre numero de Carte Bancaire :");
        int numeroCarte = Clavier.entrerClavierInt();
        System.out.println("Veuillez saisir la date d expiration de votre carte de bancaire (MMAA) :");
        int dateCarte = Clavier.entrerClavierInt();

        boolean carteValide = controlEnregisterDonneBanquaire.enregistrerCoordonneesBancaires(numClient,numeroCarte,dateCarte);

        if (!carteValide){
            System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir");
        }

        return carteValide;
    }

}
