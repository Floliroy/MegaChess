package personnage.origines;

import objet.typestat.Deplacements;

public abstract interface Ionia extends Origine, Deplacements {

	public default Class<?> getOrigine() {
		return Ionia.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Deplacements.getTypeStat();
	}
	
}
