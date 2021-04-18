package personnage.elements;

import java.io.Serializable;

public abstract interface Element extends Serializable {

	public Class<?> getElement();

	public Class<?> getElementTypeStat();
	
}
