package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

public abstract class Profil {
    //attributs
    private String nom;
    private String prenom;
    private String mdp;
    private String login;
    private boolean connecte = false;

    //constructeur
    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.login = prenom + "." + nom;
    }

    //methodes

    public boolean verifierCorrespondanceProfil(String login, String mdp){
        return this.login.equals(login) && this.mdp.equals(mdp);
    }

    public void connexionProfil(){
        connecte = true;
    }

    public boolean isConnecte() {
        return connecte;
    }

    @Override
    public String toString() {
        return  "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mdp='" + mdp + '\'' +
                ", login='" + login + '\'';
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getPrenom() {
        return prenom;
    }


}
