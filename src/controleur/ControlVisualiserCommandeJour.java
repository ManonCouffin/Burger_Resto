package controleur;
/*
    Créateur du fichier : Manon COUFFIN
*/

import modele.BDCommande;
import modele.ProfilUtilisateur;

import java.beans.PropertyChangeListener;

public class ControlVisualiserCommandeJour {
    //attributs
    private BDCommande bdCommande;
    private ControlVerifierIdentification controlVerifierIdentification;

    //constructeur
    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification){
        this.controlVerifierIdentification = controlVerifierIdentification;
        bdCommande = BDCommande.getInstance();
    }

    //methodes
    public void setListener(String propertyName, PropertyChangeListener listener){
        bdCommande.addPropertyChangeListener(propertyName, listener);
    }

    public boolean verifierIdentification(int numPersonnel, ProfilUtilisateur profilPersonnel){
        return controlVerifierIdentification.verifierIdentification(profilPersonnel,numPersonnel);
    }
}
