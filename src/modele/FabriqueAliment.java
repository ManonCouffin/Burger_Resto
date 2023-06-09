package modele;
/*
    Créateur du fichier : Manon COUFFIN
*/

public class FabriqueAliment {
    //methodes
    public static Aliment creerAliment(AlimentMenu typeAliment, String nom){
        Aliment aliment;
        switch (typeAliment){

            case HAMBURGER:
                aliment = new Hamburger(nom);
                break;

            case BOISSON:
                aliment = new Boisson(nom);
                break;

            default:
                aliment = new Accompagnement(nom);
                break;
        }
        return aliment;
    }

}
