package personnage.origines;

import objets.typestat.Vie;

public interface Demacia extends Origine, Vie {

	public default String getOrigine() {
		return "Demacia";
	}
	
}
