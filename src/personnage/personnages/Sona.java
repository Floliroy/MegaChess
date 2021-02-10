package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.Demacia;

public class Sona extends Personnage implements Demacia, Eau {

	private static final String nom = "Sona";
	private static final Integer vie = 80;
	private static final Integer deplacements = 2;
	private static final Integer degats = 15;
	private static final Integer portee = 6;
	private static final Double vitesse = 0.4;
	
	public Sona() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
