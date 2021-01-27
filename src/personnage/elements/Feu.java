package personnage.elements;

import objets.typestat.Degats;

public interface Feu extends Element, Degats {

	public default String getElement() {
		return "Feu";
	}
	
}
