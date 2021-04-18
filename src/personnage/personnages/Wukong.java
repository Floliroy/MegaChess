package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Feu;
import personnage.origines.Ionia;

public class Wukong extends Personnage implements Ionia, Feu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7541666763676390936L;
	private static final String nom = "Wukong";
	private static final Integer vie = 120;
	private static final Integer deplacements = 3;
	private static final Integer degats = 25;
	private static final Integer portee = 3;
	private static final Double vitesse = 0.6;
	
	public Wukong() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
