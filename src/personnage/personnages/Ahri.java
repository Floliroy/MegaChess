package personnage.personnages;

import personnage.Personnage;
import personnage.elements.Eau;
import personnage.origines.Ionia;

public class Ahri extends Personnage implements Ionia, Eau {

	public Ahri() {
		super("Ahri");
	}

	@Override
	public String getTypeStat() {
		return Ionia.super.getTypeStat() + Eau.super.getTypeStat();
	}

}