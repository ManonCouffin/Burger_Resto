package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.*;

public class ControlVerifierIdentification {
    //atributs
    private BDClient bdClient= BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();;

    //constructeur
    public ControlVerifierIdentification(){
        bdClient = BDClient.getInstance();
        bdPersonnel = BDPersonnel.getInstance();
    }

    //mehode
    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numProfil) {
        boolean connexionOK = false;
        Personnel personnel;
        switch (profilUtilisateur) {
            case CLIENT:
                Client client = bdClient.trouverClient(numProfil);
                if (client != null){
                    connexionOK = client.isConnecte();
                }
                break;

            case PERSONNEL:
                personnel = bdPersonnel.trouverPersonnel(numProfil);
                if (personnel != null){
                    connexionOK = personnel.isConnecte();
                }
                break;

            default:
                personnel = bdPersonnel.trouverPersonnel(numProfil);
                if (personnel != null) {
                    if (personnel.isGerant()){
                        connexionOK = personnel.isConnecte();
                    }
                }
                break;
        }
        return connexionOK;
    }
}
