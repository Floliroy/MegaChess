package personnage.elements;

import java.io.Serializable;
/**
 * Création de l'interface Element :
 *  - Nature de l'élément (Eau, Feu ...)
 *  - Type de stat de l'élément (Dégats, Vie ...)
 * 
 */
public abstract interface Element extends Serializable {

	public Class<?> getElement();

	public Class<?> getElementTypeStat();
	
}
