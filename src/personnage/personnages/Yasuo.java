package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Ionia;

public class Yasuo extends Personnage implements Ionia, Vent {

	private static final String nom = "Yasuo";
	private static final Integer vie = 100;
	private static final Integer deplacements = 4;
	private static final Integer degats = 30;
	private static final Integer portee = 2;
	
	public Yasuo() {
		super(nom, vie, deplacements, degats, portee);
	}
	
}
