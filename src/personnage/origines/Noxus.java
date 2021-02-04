package personnage.origines;

import objet.typestat.Degats;

public interface Noxus extends Origine, Degats {

	public default String getOrigine() {
		return "Noxus";
	}
	
}
