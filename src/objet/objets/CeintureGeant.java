package objet.objets;

import objet.Objet;
import objet.typestat.Vie;

public class CeintureGeant extends Objet implements Vie {

	/**
	 * Initialise l'objet Ceinture de Géant qui donne 50 de vie à son porteur
	 */	
	public CeintureGeant() {
		super("Ceinture de G�ant", 50);
	}
}
