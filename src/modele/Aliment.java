package modele;

public abstract class Aliment{
    //attributs
    private String nom;

    //constructeur
    public Aliment(String n){
        nom = n;
    }

    //methode
    public String getNom() {
            return nom;
    }

    @Override
    public String toString() {
        return "Aliment [" +
                "nom=" + nom +
                ']';
    }


}
