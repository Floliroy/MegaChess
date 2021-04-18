package objet.objets;

import objet.Objet;
import objet.typestat.Vitesse;

public class ArcCourbe extends Objet implements Vitesse {
	
	/**
	 * Initialise l'objet Arc Courbe qui donne 20 de vitesse à son porteur
	 */
	 public ArcCourbe() {
		super("Arc Courbe", 20);
	}
		
}
