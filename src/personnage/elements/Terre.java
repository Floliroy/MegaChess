package personnage.elements;

import objet.typestat.Vie;

public abstract interface Terre extends Element, Vie {

	public default Class<?> getElement() {
		return Terre.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Vie.getTypeStat();
	}
	
}
