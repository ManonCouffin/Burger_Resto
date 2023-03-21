package vueConsole;
/*
    Créateur du fichier : Manon COUFFIN
*/

import controleur.ControlVisualiserCommandeJour;
import modele.Commande;
import modele.ProfilUtilisateur;
import modele.PropertyName;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {
    //attributs
    private ControlVisualiserCommandeJour controlVisualiserCommandeJour;

    //constructeur
    public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour){
        this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
        //this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(),this);
    }

    //methodes
    public void visualiserCommandeJour(int numPersonnel){
        if (controlVisualiserCommandeJour.verifierIdentification(numPersonnel, ProfilUtilisateur.PERSONNEL)){
            this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
            controlVisualiserCommandeJour.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(), this);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        PropertyName choix = PropertyName.valueOf(propertyName);

        switch (choix){
            case ENREGISTRER_COMMANDE -> {
                Commande commande = (Commande) evt.getNewValue();
                Affichage.ecrire("Commande n" + commande.getNumeroCommandeAttribuee() + " : " + commande.getHamburger() + ", "
                        + commande.getAccompagnement() + ", " + commande.getBoisson() + ".");
            }
            case VIDER_COMMANDE_JOUR -> {
                Affichage.effacer();
            }
            default -> {
                System.out.println("ERREUR");
            }
        }
    }
}
