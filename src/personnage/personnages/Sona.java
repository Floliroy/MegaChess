package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.Demacia;

public class Sona extends Personnage implements Demacia, Eau {

	/**
	 * Initialise le personnage Sona avec pour capacités :
	 *  - vie = 80
	 *  - degats = 15
	 *  - deplacements = 2
	 *  - portee = 6
	 *  - vitesse = 0,4
	 */
	private static final long serialVersionUID = -6225478158371982502L;
	private static final String nom = "Sona";
	private static final Integer vie = 80;
	private static final Integer deplacements = 2;
	private static final Integer degats = 15;
	private static final Integer portee = 6;
	private static final Double vitesse = 0.4;
	
	public Sona() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
