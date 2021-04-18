package personnage.origines;

import java.io.Serializable;
/**
 * Création de l'interface Origine :
 *  - Nature de l'origine (Ionia , Noxus ...)
 *  - Type de stat de l'origine (Portée, Déplacements ...)
 * 
 */
public abstract interface Origine extends Serializable {
	
	public Class<?> getOrigine();
	
	public Class<?> getOrigineTypeStat();
	
}
