package personnage.elements;

import objet.typestat.Deplacements;

public interface Vent extends Element, Deplacements {

	public default String getElement() {
		return "Vent";
	}
	
}
