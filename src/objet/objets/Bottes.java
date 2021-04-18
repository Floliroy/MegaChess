package objet.objets;

import objet.Objet;
import objet.typestat.Deplacements;

public class Bottes extends Objet implements Deplacements {
	
	/**
	 * Initialise l'objet Bottes qui donnera 2 de déplacements à son porteur
	 */
	public Bottes() {
		super("Bottes", 2);
	}

}
