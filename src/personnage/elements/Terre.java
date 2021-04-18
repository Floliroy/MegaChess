package personnage.elements;

import objet.typestat.Vie;

/**
 * Création de l'interface Terre :
 *  - Terre : élément du personnage
 *  - Ajoute de la vie au personnage
 * 
 */
public abstract interface Terre extends Element, Vie {

	public default Class<?> getElement() {
		return Terre.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Vie.getTypeStat();
	}
	
}
