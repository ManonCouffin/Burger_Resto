package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.BDClient;
import modele.Client;

public class ControlEnregistrerCoordonneesBancaires {
    //attributs
    private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
    private BDClient bdClient;

    //constructeur
    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
        bdClient = BDClient.getInstance();
    }

    //methodes
    public boolean enregistrerCoordonneesBancaires(int numClient, int numCarte, int dateCarte){
        boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonnesBancaires(numCarte,dateCarte);
        if (carteValide){
            Client client = bdClient.trouverClient(numClient);
            if (client != null) {
                client.enregistrerCoordonnesBancaires(numCarte,dateCarte);
            }
        }
        return carteValide;
    }
}
