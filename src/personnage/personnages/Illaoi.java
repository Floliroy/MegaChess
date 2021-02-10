package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.BilgeWater;

public class Illaoi extends Personnage implements BilgeWater, Terre {

	private static final String nom = "Illaoi";
	private static final Integer vie = 150;
	private static final Integer degats = 30;
	private static final Integer deplacements = 2;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.3;
	
	public Illaoi() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
