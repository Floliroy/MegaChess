package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Feu;
import personnage.origines.Noxus;

public class Kled extends Personnage implements Noxus, Feu {

	/**
	 * Initialise le personnage Kled avec pour capacités :
	 *  - vie = 150
	 *  - degats = 25
	 *  - deplacements = 6
	 *  - portee = 1
	 *  - vitesse = 0,7
	 */
	private static final long serialVersionUID = 3109399295692555903L;
	private static final String nom = "Kled";
	private static final Integer vie = 150;
	private static final Integer deplacements = 6;
	private static final Integer degats = 25;
	private static final Integer portee = 1;
	private static final Double vitesse = 0.7;
	
	public Kled() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
