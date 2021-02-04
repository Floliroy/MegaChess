package personnage.elements;

import objet.typestat.Vie;

public interface Terre extends Element, Vie {

	public default String getElement() {
		return "Terre";
	}
	
}
