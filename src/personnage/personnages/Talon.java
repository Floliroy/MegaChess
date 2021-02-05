package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Noxus;

public class Talon extends Personnage implements Noxus, Vent {

	private static final String nom = "Talon";
	private static final Integer vie = 80;
	private static final Integer deplacements = 5;
	private static final Integer degats = 50;
	private static final Integer portee = 3;
	
	public Talon() {
		super(nom, vie, deplacements, degats, portee);
	}
	
}
