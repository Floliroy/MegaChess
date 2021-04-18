package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.BilgeWater;

public class Pyke extends Personnage implements BilgeWater, Eau {

	/**
	 * Initialise le personnage Pyke avec pour capacités :
	 *  - vie = 120
	 *  - degats = 35
	 *  - deplacements = 3
	 *  - portee = 4
	 *  - vitesse = 0,4
	 */
	private static final long serialVersionUID = 5364815965123579223L;
	private static final String nom = "Pyke";
	private static final Integer vie = 120;
	private static final Integer deplacements = 3;
	private static final Integer degats = 35;
	private static final Integer portee = 4;
	private static final Double vitesse = 0.4;
	
	public Pyke() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
