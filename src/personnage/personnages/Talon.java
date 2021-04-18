package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Noxus;

public class Talon extends Personnage implements Noxus, Vent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -530820033801355466L;
	private static final String nom = "Talon";
	private static final Integer vie = 80;
	private static final Integer deplacements = 5;
	private static final Integer degats = 50;
	private static final Integer portee = 3;
	private static final Double vitesse = 0.5;
	
	public Talon() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
