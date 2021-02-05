package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.Noxus;

public class Sion extends Personnage implements Noxus, Terre {

	private static final String nom = "Sion";
	private static final Integer vie = 200;
	private static final Integer deplacements = 2;
	private static final Integer degats = 15;
	private static final Integer portee = 1;
	
	public Sion() {
		super(nom, vie, deplacements, degats, portee);
	}
	
}
