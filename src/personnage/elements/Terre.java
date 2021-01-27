package personnage.elements;

import objets.typestat.Vie;

public interface Terre extends Element, Vie {

	public default String getElement() {
		return "Terre";
	}
	
}
