package personnage.origines;

import objets.typestat.Deplacements;

public interface Ionia extends Origine, Deplacements {

	public default String getOrigine() {
		return "Ionia";
	}
	
}
