package personnage.elements;

import objet.typestat.Deplacements;

/**
 * Création de l'interface Vent :
 *  - Vent : élément du personnage
 *  - Ajoute des déplacements au personnage
 * 
 */
public abstract interface Vent extends Element, Deplacements {

	public default Class<?> getElement() {
		return Vent.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Deplacements.getTypeStat();
	}
	
}
