package personnage.elements;

import objets.typestat.Deplacements;

public interface Vent extends Element, Deplacements {

	public default String getElement() {
		return "Vent";
	}
	
}
