package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.BilgeWater;

public class Fizz extends Personnage implements BilgeWater, Eau {

	/**
	 * Initialise le personnage Fizz avec pour capacités :
	 *  - vie = 100
	 *  - degats = 40
	 *  - deplacements = 4
	 *  - portee = 2
	 *  - vitesse = 0,4
	 */
	private static final long serialVersionUID = 8507563459542728609L;
	private static final String nom = "Fizz";
	private static final Integer vie = 100;
	private static final Integer degats = 40;
	private static final Integer deplacements = 4;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.4;
	
	public Fizz() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
