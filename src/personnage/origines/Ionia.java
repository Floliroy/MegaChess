package personnage.origines;

import objet.typestat.Deplacements;

public interface Ionia extends Origine, Deplacements {

	public default String getOrigine() {
		return "Ionia";
	}
	
}
