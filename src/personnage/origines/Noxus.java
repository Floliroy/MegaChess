package personnage.origines;

import objet.typestat.Degats;

public abstract interface Noxus extends Origine, Degats {

	public default Class<?> getOrigine() {
		return Noxus.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Degats.getTypeStat();
	}
	
}
