package personnage.origines;

import objet.typestat.Vie;

/**
 * Création de l'interface Demacia :
 *  - Demacia : origine du personnage
 *  - Ajoute de la vie au personnage
 * 
 */
public abstract interface Demacia extends Origine, Vie {

	public default Class<?> getOrigine() {
		return Demacia.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Vie.getTypeStat();
	}
	
}
