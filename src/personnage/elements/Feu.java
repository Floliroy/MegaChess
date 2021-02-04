package personnage.elements;

import objet.typestat.Degats;

public abstract interface Feu extends Element, Degats {

	public default Class<?> getElement() {
		return Feu.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Degats.getTypeStat();
	}
	
}
