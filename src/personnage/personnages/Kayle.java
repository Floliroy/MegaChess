package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Demacia;

public class Kayle extends Personnage implements Demacia, Vent {

	/**
	 * Initialise le personnage Kayle avec pour capacités :
	 *  - vie = 100
	 *  - degats = 25
	 *  - deplacements = 2
	 *  - portee = 6
	 *  - vitesse = 0,6
	 */
	private static final long serialVersionUID = 8794078855336180535L;
	private static final String nom = "Kayle";
	private static final Integer vie = 100;
	private static final Integer deplacements = 2;
	private static final Integer degats = 25;
	private static final Integer portee = 6;
	private static final Double vitesse = 0.6;
	
	public Kayle() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
