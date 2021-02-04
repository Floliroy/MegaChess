package test;

import personnage.Equipe;
import personnage.personnages.Ahri;

public class Test {

	public static void main(String[] args) {
		Ahri ahri = new Ahri();
		Ahri ahri2 = new Ahri();
		Equipe equipe = new Equipe();
		equipe.add(ahri);
		equipe.add(ahri2);
		
		System.out.println(ahri.getDeplacementsAvecBonus());
	}

}
