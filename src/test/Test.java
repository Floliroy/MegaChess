package test;

import personnage.Equipe;
import personnage.personnages.Ahri;

public class Test {

	public static void main(String[] args) {
		Ahri ahri = new Ahri();
		Equipe equipe = new Equipe();
		equipe.add(ahri);
		
		System.out.println(ahri.getDeplacementsAvecBonus());
	}

}
