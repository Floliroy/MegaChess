package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.BilgeWater;

public class Illaoi extends Personnage implements BilgeWater, Terre {

	/**
	 * Initialise le personnage Illaoi avec pour capacités :
	 *  - vie = 150
	 *  - degats = 30
	 *  - deplacements = 2
	 *  - portee = 2
	 *  - vitesse = 0,3
	 */
	private static final long serialVersionUID = -2097827763397616551L;
	private static final String nom = "Illaoi";
	private static final Integer vie = 150;
	private static final Integer degats = 30;
	private static final Integer deplacements = 2;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.3;
	
	public Illaoi() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
