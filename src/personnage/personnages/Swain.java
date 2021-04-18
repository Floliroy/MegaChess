package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Feu;
import personnage.origines.Noxus;

public class Swain extends Personnage implements Noxus, Feu {

	/**
	 * Initialise le personnage Swain avec pour capacités :
	 *  - vie = 180
	 *  - degats = 20
	 *  - deplacements = 2
	 *  - portee = 5
	 *  - vitesse = 0,4
	 */
	private static final long serialVersionUID = -474319239446476603L;
	private static final String nom = "Swain";
	private static final Integer vie = 180;
	private static final Integer deplacements = 2;
	private static final Integer degats = 20;
	private static final Integer portee = 5;
	private static final Double vitesse = 0.4;
	
	public Swain() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
