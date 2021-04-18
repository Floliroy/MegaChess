package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.Demacia;

public class Poppy extends Personnage implements Demacia, Terre {

	/**
	 * Initialise le personnage Poppy avec pour capacités :
	 *  - vie = 180
	 *  - degats = 8
	 *  - deplacements = 5
	 *  - portee = 2
	 *  - vitesse = 0,4
	 */
	private static final long serialVersionUID = 2509497404212620615L;
	private static final String nom = "Poppy";
	private static final Integer vie = 180;
	private static final Integer deplacements = 5;
	private static final Integer degats = 8;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.4;
	
	public Poppy() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
