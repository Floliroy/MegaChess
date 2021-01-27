package personnage.origines;

import objets.typestat.Portee;

public interface BilgeWater extends Origine, Portee {

	public default String getOrigine() {
		return "BilgeWater";
	}
	
}
