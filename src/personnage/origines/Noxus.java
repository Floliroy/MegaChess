package personnage.origines;

import objets.typestat.Degats;

public interface Noxus extends Origine, Degats {

	public default String getOrigine() {
		return "Noxus";
	}
	
}
