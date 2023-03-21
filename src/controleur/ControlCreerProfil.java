package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.*;

public class ControlCreerProfil {
    //attributs
    private BDClient bdClient;
    private BDPersonnel bdPersonnel;

    //constructeur
    public ControlCreerProfil() {
        bdClient = BDClient.getInstance();
        bdPersonnel = BDPersonnel.getInstance();
    }

    //methodes
    public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp){
        Profil profil = FabriqueProfil.creerProfil(profilUtilisateur,nom,prenom,mdp);

        if (profilUtilisateur == ProfilUtilisateur.CLIENT){
            bdClient.ajouterClient((Client) profil);
        }
        else {
            bdPersonnel.ajouterPersonnel((Personnel) profil);
        }
    }

    public String visualiserBDUtilisateur(){
        return (bdPersonnel + "\n" + bdClient);
    }
}
