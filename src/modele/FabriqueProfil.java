package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

public class FabriqueProfil {
    //methodes
    public static Profil creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp){
        Profil profil;
        switch (profilUtilisateur){

            case GERANT:
                Personnel gerant = new Personnel(nom, prenom,mdp);
                gerant.definirGerant();
                profil = gerant;
                break;

            case PERSONNEL:
                profil = new Personnel(nom, prenom,mdp);
                break;

            default:
                profil = new Client(nom,prenom,mdp);
                break;
        }
        return profil;
    }
}
