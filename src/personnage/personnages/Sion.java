package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.Noxus;

public class Sion extends Personnage implements Noxus, Terre {

	/**
	 * Initialise le personnage Sion avec pour capacités :
	 *  - vie = 200
	 *  - degats = 15
	 *  - deplacements = 2
	 *  - portee = 1
	 *  - vitesse = 0,3
	 */
	private static final long serialVersionUID = 4318697447674103945L;
	private static final String nom = "Sion";
	private static final Integer vie = 200;
	private static final Integer deplacements = 2;
	private static final Integer degats = 15;
	private static final Integer portee = 1;
	private static final Double vitesse = 0.3;
	
	public Sion() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
