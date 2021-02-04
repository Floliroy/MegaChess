package personnage.origines;

import objet.typestat.Vie;

public abstract interface Demacia extends Origine, Vie {

	public default Class<?> getOrigine() {
		return Demacia.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Vie.getTypeStat();
	}
	
}
