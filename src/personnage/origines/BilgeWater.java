package personnage.origines;

import objet.typestat.Portee;

/**
 * Création de l'interface Bilgewater :
 *  - Bilgewater : origine du personnage
 *  - Ajoute de la portée au personnage
 * 
 */
public abstract interface BilgeWater extends Origine, Portee {

	public default Class<?> getOrigine() {
		return BilgeWater.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Portee.getTypeStat();
	}
	
}
