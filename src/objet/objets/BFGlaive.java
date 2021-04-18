package objet.objets;

import objet.Objet;
import objet.typestat.Degats;

public class BFGlaive extends Objet implements Degats{
	/**
	 * Initialise l'objet BF Glaive  qui donne 15 de dégats à son porteur
	 */
	public BFGlaive() {
		super("BF Glaive", 15);
	}
}
