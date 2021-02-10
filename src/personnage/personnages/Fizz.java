package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.BilgeWater;

public class Fizz extends Personnage implements BilgeWater, Eau {

	private static final String nom = "Fizz";
	private static final Integer vie = 100;
	private static final Integer degats = 40;
	private static final Integer deplacements = 4;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.4;
	
	public Fizz() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
