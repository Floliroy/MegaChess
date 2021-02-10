package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Terre;
import personnage.origines.Demacia;

public class Jarvan extends Personnage implements Demacia, Terre {

	private static final String nom = "Jarvan";
	private static final Integer vie = 150;
	private static final Integer deplacements = 5;
	private static final Integer degats = 20;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.5;
	
	public Jarvan() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
