package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Feu;
import personnage.origines.Demacia;

public class Shyvana extends Personnage implements Demacia, Feu {

	private static final String nom = "Shyvana";
	private static final Integer vie = 150;
	private static final Integer deplacements = 4;
	private static final Integer degats = 20;
	private static final Integer portee = 3;
	private static final Double vitesse = 0.7;
	
	public Shyvana() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}

}
