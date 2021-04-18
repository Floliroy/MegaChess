package personnage.elements;

import objet.typestat.Portee;

/**
 * Création de l'interface Eau :
 *  - Eau : élément du personnage
 *  - Ajoute de la portée au personnage
 * 
 */
public abstract interface Eau extends Element, Portee {

	public default Class<?> getElement() {
		return Eau.class;
	}
	
	public default Class<?> getElementTypeStat() {
		return Portee.getTypeStat();
	}
	
}
