package personnage.elements;

import objet.typestat.Deplacements;

public abstract interface Vent extends Element, Deplacements {

	public default Class<?> getElement() {
		return Vent.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Deplacements.getTypeStat();
	}
	
}
