package personnage.elements;

import objet.typestat.Portee;

public abstract interface Eau extends Element, Portee {

	public default Class<?> getElement() {
		return Eau.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Portee.getTypeStat();
	}
	
}
