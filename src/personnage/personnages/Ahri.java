package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.Ionia;

public class Ahri extends Personnage implements Ionia, Eau {

	/**
	 * Initialise le personnage Ahri avec pour capacités :
	 *  - vie = 80
	 *  - degats = 30
	 *  - deplacements = 4
	 *  - portee = 6
	 *  - vitesse = 0,5
	 */
	private static final long serialVersionUID = 758435429718851684L;
	private static final String nom = "Ahri";
	private static final Integer vie = 80;
	private static final Integer degats = 30;
	private static final Integer deplacements = 4;
	private static final Integer portee = 6;
	private static final Double vitesse = 0.5;
	
	public Ahri() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}

}
