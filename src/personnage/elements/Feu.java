package personnage.elements;

import objet.typestat.Degats;

public interface Feu extends Element, Degats {

	public default String getElement() {
		return "Feu";
	}
	
}
