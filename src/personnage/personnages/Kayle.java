package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Demacia;

public class Kayle extends Personnage implements Demacia, Vent {

	private static final String nom = "Kayle";
	private static final Integer vie = 100;
	private static final Integer deplacements = 2;
	private static final Integer degats = 25;
	private static final Integer portee = 6;
	
	public Kayle() {
		super(nom, vie, deplacements, degats, portee);
	}
	
}
