package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

public class Commande {
    //attributs
    private int numClient;
    private Hamburger hamburger;
    private Accompagnement accompagnement;
    private Boisson boisson;
    private int numeroCommandeAttribuee;
    private static int numeroCommande = 0;

    //constructeur
    public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        numeroCommande++;
        this.numClient = numClient;
        this.hamburger = hamburger;
        this.accompagnement = accompagnement;
        this.boisson = boisson;
        this.numeroCommandeAttribuee = numeroCommande;
    }

    //methodes
    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }

    public int getNumClient() {
        return numClient;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Accompagnement getAccompagnement() {
        return accompagnement;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public static void resetNumCommande() {
        numeroCommande = 0;
    }
}
