package personnage.elements;

import objet.typestat.Portee;

public interface Eau extends Element, Portee {

	public default String getElement() {
		return "Eau";
	}
	
}
