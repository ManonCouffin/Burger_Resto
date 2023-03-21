package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.*;

public class ControlAjouterAlimentMenu {
    //attributs
    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();

    //constructeur
    public ControlAjouterAlimentMenu(ControlVerifierIdentification c){
        controlVerifierIdentification = c;
    }

    //methodes

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil){
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }

    public void ajouterAliment(AlimentMenu typeAliment, String nom){
        switch (typeAliment){
            case HAMBURGER:
                menu.ajouterAliment((Hamburger) FabriqueAliment.creerAliment(typeAliment, nom));
                break;

            case BOISSON:
                menu.ajouterAliment((Boisson) FabriqueAliment.creerAliment(typeAliment, nom));
                break;

            default:
                menu.ajouterAliment((Accompagnement) FabriqueAliment.creerAliment(typeAliment, nom));
                break;
        }
    }

    public String visualiserMenu() {
        return menu.toString();
    }
}
