package personnage.origines;

import objet.typestat.Vie;

public interface Demacia extends Origine, Vie {

	public default String getOrigine() {
		return "Demacia";
	}
	
}
