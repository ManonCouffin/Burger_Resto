package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

public class Personnel extends Profil {
    //attributs
    private boolean gerant = false;

    //constructeur
    public Personnel(String nom, String prenom, String mdp){
        super(nom,prenom,mdp);
    }

    //methodes
    public void definirGerant(){
        gerant = true;
    }

    public boolean isGerant() {
        return gerant;
    }

    @Override
    public String toString() {
        return "Personnel[" +
                "gerant=" + gerant + "," + super.toString() +
                ']';
    }
}
