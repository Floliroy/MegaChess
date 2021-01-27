package personnage.elements;

import objets.typestat.Portee;

public interface Eau extends Element, Portee {

	public default String getElement() {
		return "Eau";
	}
	
}
