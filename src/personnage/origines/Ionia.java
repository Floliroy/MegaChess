package personnage.origines;

import objet.typestat.Deplacements;

/**
 * Création de l'interface Ionia :
 *  - Ionia : origine du personnage
 *  - Ajoute des déplacements au personnage
 * 
 */

public abstract interface Ionia extends Origine, Deplacements {

	public default Class<?> getOrigine() {
		return Ionia.class;
	}
	
	public default Class<?> getOrigineTypeStat() {
		return Deplacements.getTypeStat();
	}
	
}
