package personnage.origines;

import java.io.Serializable;

public abstract interface Origine extends Serializable {
	
	public Class<?> getOrigine();
	
	public Class<?> getOrigineTypeStat();
	
}
