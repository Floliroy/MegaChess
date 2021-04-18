package personnage.origines;

import objet.typestat.Degats;

/**
 * Création de l'interface Noxus :
 *  - Noxus : origine du personnage
 *  - Ajoute des dégats au personnage
 * 
 */
public abstract interface Noxus extends Origine, Degats {

	public default Class<?> getOrigine() {
		return Noxus.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Degats.getTypeStat();
	}
	
}
