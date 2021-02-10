package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Demacia;

public class Quinn extends Personnage implements Demacia, Vent {

	private static final String nom = "Quinn";
	private static final Integer vie = 80;
	private static final Integer deplacements = 4;
	private static final Integer degats = 30;
	private static final Integer portee = 8;
	private static final Double vitesse = 0.7;
	
	public Quinn() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
