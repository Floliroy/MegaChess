package test;

import personnage.Equipe;
import personnage.Personnage;
import personnage.personnages.Ahri;
import personnage.personnages.Fizz;

public class Test {

	private static void attaque(Personnage attaquant, Personnage defenseur) {
		attaquant.attaque(defenseur);
		if(defenseur.getVitesseAvecBonus() >= attaquant.getVitesseAvecBonus() && defenseur.isVivant()) {
			defenseur.attaque(attaquant);
		}
	}
	
	public static void main(String[] args) {
		Equipe equipe1 = new Equipe();
		Equipe equipe2 = new Equipe();
		
		Ahri ahri = new Ahri();
		equipe1.add(ahri);
		Fizz fizz = new Fizz();
		equipe2.add(fizz);
		
		attaque(fizz, ahri);
	}

}
