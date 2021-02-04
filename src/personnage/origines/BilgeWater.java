package personnage.origines;

import objet.typestat.Portee;

public interface BilgeWater extends Origine, Portee {

	public default String getOrigine() {
		return "BilgeWater";
	}
	
}
