package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.BDClient;
import modele.BDPersonnel;
import modele.ProfilUtilisateur;

public class ControlSIdentifier {
    //attributs
    private BDClient bdClient;
    private BDPersonnel bdPersonnel;

    //constructeur
    public ControlSIdentifier(){
        bdClient = BDClient.getInstance();
        bdPersonnel = BDPersonnel.getInstance();
    }

    //methodes
    public int sIdentifier(ProfilUtilisateur profilUtilisateur, String login, String mdp){
        int id;
        switch (profilUtilisateur){
            case CLIENT:
                id = bdClient.connexionClient(login, mdp);
                break;
            default:
                id = bdPersonnel.connexionPersonnel(login, mdp);
                break;
        }
        return id;
    }

    public String visualiserBDUtilisateur() {
        return (bdPersonnel + "\n" + bdClient);
    }
}
