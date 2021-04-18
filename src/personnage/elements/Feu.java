package personnage.elements;

import objet.typestat.Degats;

/**
 * Création de l'interface Feu :
 *  - Feu : élément du personnage
 *  - Ajoute des dégats au personnage
 * 
 */

public abstract interface Feu extends Element, Degats {

	public default Class<?> getElement() {
		return Feu.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Degats.getTypeStat();
	}
	
}
