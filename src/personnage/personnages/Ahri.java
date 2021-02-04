package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.Ionia;

public class Ahri extends Personnage implements Ionia, Eau {

	private static final String nom = "Ahri";
	private static final Integer vie = 80;
	private static final Integer degats = 30;
	private static final Integer deplacements = 4;
	private static final Integer portee = 6;
	
	public Ahri() {
		super(nom, vie, degats, deplacements, portee);
	}

}
