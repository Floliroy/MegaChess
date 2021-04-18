package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Vent;
import personnage.origines.Ionia;

public class Yasuo extends Personnage implements Ionia, Vent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6290874682638672874L;
	private static final String nom = "Yasuo";
	private static final Integer vie = 100;
	private static final Integer deplacements = 4;
	private static final Integer degats = 30;
	private static final Integer portee = 2;
	private static final Double vitesse = 0.7;
	
	public Yasuo() {
		super(nom, vie, degats, deplacements, portee, vitesse);
	}
	
}
