package personnage.origines;

import objet.typestat.Portee;

public abstract interface BilgeWater extends Origine, Portee {

	public default Class<?> getOrigine() {
		return BilgeWater.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Portee.getTypeStat();
	}
	
}
